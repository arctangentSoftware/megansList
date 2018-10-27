package com.megansList

import grails.gorm.services.Service

@Service(PropertyManager)
interface PropertyManagerService {

    PropertyManager get(Serializable id)

    List<PropertyManager> list(Map args)

    Long count()

    void delete(Serializable id)

    PropertyManager save(PropertyManager propertyManager)

}