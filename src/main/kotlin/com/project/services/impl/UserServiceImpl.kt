package com.project.services.impl

import com.project.models.User
import com.project.repository.UserRepository
import com.project.services.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository):UserService {

    override fun findByUsername(name: String): User? {
        return userRepository.findByUsername(name)
    }

    override fun findAll(): List<User?>? {
        return userRepository.findAll()
    }

    override fun findOne(id: Long): User? {
        return userRepository.findOne(id)
    }

}