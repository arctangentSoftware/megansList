package com.megansList

import grails.gorm.services.Service

@Service(Review)
interface ReviewService {

    Review get(Serializable id)

    List<Review> list(Map args)

    Long count()

    void delete(Serializable id)

    Review save(Review review)

}