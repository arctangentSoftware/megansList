package com.megansList

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class PropertyManager extends User {

    String name
    String email
    Boolean individual
    Address address

    /**
     * Calculated rating based on the ratings of their properties and landlords
     */
    BigDecimal rating = BigDecimal.ZERO

    //TODO: Maybe just a Set
    static hasMany = [rentalProperties: Property]

    static constraints = {
        name(nullable: false, blank: false, unique: true)
        address(nullable: false, blank: false, unique: true)
    }
}
