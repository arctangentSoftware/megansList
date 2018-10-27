package com.megansList

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReviewServiceSpec extends Specification {

    ReviewService reviewService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Review(...).save(flush: true, failOnError: true)
        //new Review(...).save(flush: true, failOnError: true)
        //Review review = new Review(...).save(flush: true, failOnError: true)
        //new Review(...).save(flush: true, failOnError: true)
        //new Review(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //review.id
    }

    void "test get"() {
        setupData()

        expect:
        reviewService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Review> reviewList = reviewService.list(max: 2, offset: 2)

        then:
        reviewList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reviewService.count() == 5
    }

    void "test delete"() {
        Long reviewId = setupData()

        expect:
        reviewService.count() == 5

        when:
        reviewService.delete(reviewId)
        sessionFactory.currentSession.flush()

        then:
        reviewService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Review review = new Review()
        reviewService.save(review)

        then:
        review.id != null
    }
}
