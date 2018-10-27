package com.megansList

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PropertyManagerServiceSpec extends Specification {

    PropertyManagerService propertyManagerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PropertyManager(...).save(flush: true, failOnError: true)
        //new PropertyManager(...).save(flush: true, failOnError: true)
        //PropertyManager propertyManager = new PropertyManager(...).save(flush: true, failOnError: true)
        //new PropertyManager(...).save(flush: true, failOnError: true)
        //new PropertyManager(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //propertyManager.id
    }

    void "test get"() {
        setupData()

        expect:
        propertyManagerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PropertyManager> propertyManagerList = propertyManagerService.list(max: 2, offset: 2)

        then:
        propertyManagerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        propertyManagerService.count() == 5
    }

    void "test delete"() {
        Long propertyManagerId = setupData()

        expect:
        propertyManagerService.count() == 5

        when:
        propertyManagerService.delete(propertyManagerId)
        sessionFactory.currentSession.flush()

        then:
        propertyManagerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PropertyManager propertyManager = new PropertyManager()
        propertyManagerService.save(propertyManager)

        then:
        propertyManager.id != null
    }
}
