package com.megansList

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class Address {

    String street
    String city
    String state
    String country
    String zipCode
    Long latitude
    Long longitude

    static constraints = {
        street(nullable:false)
        city(nullable:false)
        state(nullable:false)
        country(nullable:false)
        zipCode(nullable:false)
        latitude(nullable:true)
        longitude(nullable:true)
    }

    String toString() {
        (street ?: '') + (' ' + (city ?: '')) + (' ' + (state ?: '')) + (zipCode ? ", $zipCode" : '')
    }
}
