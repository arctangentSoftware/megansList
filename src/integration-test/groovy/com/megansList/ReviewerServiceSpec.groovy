package com.megansList

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReviewerServiceSpec extends Specification {

    ReviewerService reviewerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Reviewer(...).save(flush: true, failOnError: true)
        //new Reviewer(...).save(flush: true, failOnError: true)
        //Reviewer reviewer = new Reviewer(...).save(flush: true, failOnError: true)
        //new Reviewer(...).save(flush: true, failOnError: true)
        //new Reviewer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reviewer.id
    }

    void "test get"() {
        setupData()

        expect:
        reviewerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Reviewer> reviewerList = reviewerService.list(max: 2, offset: 2)

        then:
        reviewerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reviewerService.count() == 5
    }

    void "test delete"() {
        Long reviewerId = setupData()

        expect:
        reviewerService.count() == 5

        when:
        reviewerService.delete(reviewerId)
        sessionFactory.currentSession.flush()

        then:
        reviewerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Reviewer reviewer = new Reviewer()
        reviewerService.save(reviewer)

        then:
        reviewer.id != null
    }
}
