package com.megansList

import com.megansList.Role
import com.megansList.User
import com.megansList.UserRole

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def userRole = new Role(authority: 'ROLE_USER').save()

        def adminUser = new User(username: 'admin', password: 'password').save()

        def testUser = new User(username: 'test', password: 'password').save()

        UserRole.create adminUser, adminRole

        UserRole.create testUser, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2
    }

    def destroy = {
    }
}
