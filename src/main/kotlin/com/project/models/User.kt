package com.project.models

import javax.persistence.*

@Entity
class User {
    @Id
    private var id: Long? = null
    private var username: String? = null
    private var password: String? = null
    private var role: String? = null

    fun getId(): Long? {
        return this.id
    }

    fun getUsername(): String? {
        return this.username
    }

    fun getPassword(): String? {
        return this.password
    }

    fun getRole(): String? {
        return this.role
    }

    fun setId(id: Long){
        this.id = id
    }

    fun setUsername(name: String){
        this.username = name
    }

    fun setPassword(password: String){
        this.password = password
    }

    fun setRole(role: String){
        this.role = role
    }
}