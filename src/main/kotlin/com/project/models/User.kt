package com.project.models

import javax.persistence.*

@Entity
class User {
    @Id
    var id: Long? = null
    var username: String? = null
    var password: String? = null
    var role: String? = null
}