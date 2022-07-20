package com.conny.blog.web

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class IndexController {
    @GetMapping
    fun index(authentication: Authentication): Authentication {
        return authentication
    }
}