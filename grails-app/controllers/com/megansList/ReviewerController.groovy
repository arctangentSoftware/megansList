package com.megansList

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_ADMIN')
class ReviewerController {

    ReviewerService reviewerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reviewerService.list(params), model:[reviewerCount: reviewerService.count()]
    }

    def show(Long id) {
        respond reviewerService.get(id)
    }

    def create() {
        respond new Reviewer(params)
    }

    def save(Reviewer reviewer) {
        if (reviewer == null) {
            notFound()
            return
        }

        try {
            reviewerService.save(reviewer)
        } catch (ValidationException e) {
            respond reviewer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reviewer.label', default: 'Reviewer'), reviewer.id])
                redirect reviewer
            }
            '*' { respond reviewer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reviewerService.get(id)
    }

    def update(Reviewer reviewer) {
        if (reviewer == null) {
            notFound()
            return
        }

        try {
            reviewerService.save(reviewer)
        } catch (ValidationException e) {
            respond reviewer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reviewer.label', default: 'Reviewer'), reviewer.id])
                redirect reviewer
            }
            '*'{ respond reviewer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reviewerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reviewer.label', default: 'Reviewer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reviewer.label', default: 'Reviewer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
