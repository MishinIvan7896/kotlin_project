package com.project.controllers

import com.project.models.Post
import com.project.services.impl.PostServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(val postService: PostServiceImpl) {

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long) : Post? {
        return postService.findOne(id)
    }

    @GetMapping()
    fun findAll() : List<Post?>? {
        return postService.findAll()
    }

    @PostMapping()
    fun createPost(@RequestBody post: Post) {
        postService.create(post)
    }

    @PutMapping("/{id}")
    fun updatePost(@RequestBody post: Post){
        postService.update(post)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): Boolean {
        return postService.delete(id)
    }

}