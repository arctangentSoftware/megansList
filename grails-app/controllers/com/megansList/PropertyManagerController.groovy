package com.megansList

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PropertyManagerController {

    PropertyManagerService propertyManagerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond propertyManagerService.list(params), model:[propertyManagerCount: propertyManagerService.count()]
    }

    def show(Long id) {
        respond propertyManagerService.get(id)
    }

    def create() {
        respond new PropertyManager(params)
    }

    def save(PropertyManager propertyManager) {
        if (propertyManager == null) {
            notFound()
            return
        }

        try {
            propertyManagerService.save(propertyManager)
        } catch (ValidationException e) {
            respond propertyManager.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'propertyManager.label', default: 'PropertyManager'), propertyManager.id])
                redirect propertyManager
            }
            '*' { respond propertyManager, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond propertyManagerService.get(id)
    }

    def update(PropertyManager propertyManager) {
        if (propertyManager == null) {
            notFound()
            return
        }

        try {
            propertyManagerService.save(propertyManager)
        } catch (ValidationException e) {
            respond propertyManager.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'propertyManager.label', default: 'PropertyManager'), propertyManager.id])
                redirect propertyManager
            }
            '*'{ respond propertyManager, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        propertyManagerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'propertyManager.label', default: 'PropertyManager'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'propertyManager.label', default: 'PropertyManager'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
