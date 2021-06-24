package com.project.services

import com.project.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class CustomUserDetails(private val user: User) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return Collections.singleton(SimpleGrantedAuthority(user.getRole()))
    }

    override fun getPassword(): String {
        return user.getPassword()!!
    }

    override fun getUsername(): String {
        return user.getUsername()!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}