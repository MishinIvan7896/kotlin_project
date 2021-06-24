package com.project.services

import com.project.models.User

interface UserService {

    fun findByUsername(name: String): User?
    fun findAll(): List<User?>?
    fun findOne(id: Long): User?
}