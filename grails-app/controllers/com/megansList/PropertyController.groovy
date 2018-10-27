package com.megansList

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PropertyController {

    PropertyService propertyService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond propertyService.list(params), model:[propertyCount: propertyService.count()]
    }

    def show(Long id) {
        respond propertyService.get(id)
    }

    def create() {
        respond new Property(params)
    }

    def save(Property property) {
        if (property == null) {
            notFound()
            return
        }

        try {
            propertyService.save(property)
        } catch (ValidationException e) {
            respond property.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'property.label', default: 'Property'), property.id])
                redirect property
            }
            '*' { respond property, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond propertyService.get(id)
    }

    def update(Property property) {
        if (property == null) {
            notFound()
            return
        }

        try {
            propertyService.save(property)
        } catch (ValidationException e) {
            respond property.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'property.label', default: 'Property'), property.id])
                redirect property
            }
            '*'{ respond property, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        propertyService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'property.label', default: 'Property'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'property.label', default: 'Property'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
