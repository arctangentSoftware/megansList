package com.megansList

import grails.gorm.services.Service

@Service(Reviewer)
interface ReviewerService {

    Reviewer get(Serializable id)

    List<Reviewer> list(Map args)

    Long count()

    void delete(Serializable id)

    Reviewer save(Reviewer reviewer)

}