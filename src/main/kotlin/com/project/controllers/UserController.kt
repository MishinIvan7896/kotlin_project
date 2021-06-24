package com.project.controllers

import com.project.models.User
import com.project.services.impl.UserServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val userService: UserServiceImpl) {

    @GetMapping()
    fun findAll() : List<User?>? {
        return userService.findAll()
    }

    @GetMapping("/id")
    fun findOne(id: Long) : User? {
        return userService.findOne(id)
    }
}