package com.project.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Post() {
    @Id
    private var id: Long? = null
    private var authorId: Long? = null
    private var text: String? = null

    fun setId(id: Long) {
        this.id = id
    }

    fun setAuthorId(id: Long) {
        this.authorId = id
    }


    fun setText(text: String) {
        this.text = text
    }

    fun getId() : Long? {
        return this.id
    }

    fun getAuthorId(): Long? {
        return this.authorId
    }

    fun getText() : String? {
        return this.text
    }
}
