package com.conny.blog.module.security

import com.conny.blog.model.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserAuthDetails constructor(
    private val user: UserEntity
) : UserDetails {
    fun getUser() = this.user

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.getUser().roles?.map { role -> SimpleGrantedAuthority("ROLE_${role.name}") }?.toMutableList()!!
    }

    override fun getPassword(): String {
        return this.getUser().password ?: ""
    }

    override fun getUsername(): String {
        return this.getUser().username ?: ""
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
        return this.getUser().enabledUser ?: false
    }
}