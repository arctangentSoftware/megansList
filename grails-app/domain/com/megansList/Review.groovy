package com.megansList

class Review {

    Reviewer reviewer
    String review

    static belongsTo = [property:Property]

    static constraints = {
        reviewer nullable: false
        review blank: false, type:'text'
    }
}
