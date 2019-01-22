package com.megansList

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // TODO: set the sign-up page here
        "/"(view:"/index")
        //"/" controller: 'signup', action:'newUser'
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
