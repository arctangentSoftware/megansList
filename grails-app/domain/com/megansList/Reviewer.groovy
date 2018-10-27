package com.megansList

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class Reviewer extends User {

    String displayName
    String email

    static hasMany = [reviews:Review]

    static constraints = {
        displayName blank: false
        email blank:false, email: true
    }
}
