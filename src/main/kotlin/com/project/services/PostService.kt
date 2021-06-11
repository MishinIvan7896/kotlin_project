package com.project.services

import com.project.models.Post

interface PostService {

    fun findOne(id: Long): Post?
    fun findAll(): List<Post?>?
    fun create(post: Post)
    fun update(post: Post)
    fun delete(id: Long): Boolean
}