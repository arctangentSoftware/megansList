package com.megansList

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class SignupController {

    static defaultAction = 'newUser'

    def newUser() {
        render(view: 'newUser')
    }

    def createReviewer() {
        if(!params.email) {
            flash.error "Please provide an email."
            redirect(action: "newUser")
            return
        }

        if(!params.displayName) {
            flash.error "Please provide a displayName."
            redirect(action: "newUser")
            return
        }

        if(!params.password) {
            flash.error "Please provide a password."
            redirect(action: "newUser")
            return
        }

        Reviewer reviewer = new Reviewer(
                username: params.email,
                password: params.password,
                displayName: params.displayName

        ).save(failOnError:true, flush:true)

        // TODO: maybe reviewer home w/ reviews? add their reviews to show?
        redirect(controller: 'reviewer', action: 'show', id: reviewer.id)

    }

    def createPropertyManager() {
        // TODO: do we need to test for these params or just add required to the tags?
        if(!params.email) {
            flash.error "Please provide an email."
            redirect(action: "newUser")
            return
        }

        if(!params.name) {
            flash.error "Please provide a name."
            redirect(action: "newUser")
            return
        }

        if(!params.password) {
            flash.error "Please provide a password."
            redirect(action: "newUser")
            return
        }

        // TODO: test for these params or add required to the tags
        Address address = new Address(
                street: params.street ?: "",
                city: params.city ?: "",
                state: params.state ?: "",
                country: params.country ?: "",
                zipCode: params.zipCode ?: ""
        ).save(failOnError:true, flush:true)

        PropertyManager propertyManager = new PropertyManager(
                username: params.email,
                password: params.password,
                name: params.name,
                address: address
        ).save(failOnError:true, flush:true)

        redirect(controller: 'propertyManager', action: 'show', id: propertyManager.id)
    }
}
