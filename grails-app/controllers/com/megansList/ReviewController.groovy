package com.megansList

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReviewController {

    ReviewService reviewService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reviewService.list(params), model:[reviewCount: reviewService.count()]
    }

    def show(Long id) {
        respond reviewService.get(id)
    }

    def create() {
        respond new Review(params)
    }

    def save(Review review) {
        if (review == null) {
            notFound()
            return
        }

        try {
            reviewService.save(review)
        } catch (ValidationException e) {
            respond review.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'review.label', default: 'Review'), review.id])
                redirect review
            }
            '*' { respond review, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reviewService.get(id)
    }

    def update(Review review) {
        if (review == null) {
            notFound()
            return
        }

        try {
            reviewService.save(review)
        } catch (ValidationException e) {
            respond review.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'review.label', default: 'Review'), review.id])
                redirect review
            }
            '*'{ respond review, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reviewService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'review.label', default: 'Review'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'review.label', default: 'Review'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
