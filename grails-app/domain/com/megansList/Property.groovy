package com.megansList

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class Property {

    String name
    Address address
    PropertyManager manager

    /**
     * Individual ratings. Used to calculate rating.
     */
    Set<Integer> propertyRatings
    Set<Integer> landlordRatings

    /**
     * Overall property and landlord rating. Calculated from recorded ratings.
     */
    BigDecimal propertyRating = BigDecimal.ZERO
    BigDecimal landlordRating = BigDecimal.ZERO

    static constraints = {
        name(blank: false, nullable: false, unique: true)
        address(nullable:true)
        manager(nullable: true)
    }
}
