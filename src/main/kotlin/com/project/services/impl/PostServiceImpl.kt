package com.project.services.impl

import com.project.models.Post
import com.project.repository.PostRepository
import com.project.services.PostService
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(val PostRepository: PostRepository) : PostService {

    override fun findOne(id: Long): Post? {
        return PostRepository.findOne(id)
    }

    override fun findAll(): List<Post?>? {
        return PostRepository.findAll()
    }

    override fun create(post: Post) {
        PostRepository.save(post)
    }

    override fun update(post: Post) {
        PostRepository.update(post)
    }

    override fun delete(id: Long): Boolean {
        return PostRepository.delete(id)
    }
}