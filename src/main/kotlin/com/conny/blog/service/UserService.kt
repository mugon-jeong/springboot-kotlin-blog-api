package com.conny.blog.service

import com.conny.blog.model.entity.UserEntity
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun findById(id: Long): UserEntity?

    fun findByUsername(username: String): UserEntity?

    fun existsByUsername(username: String): Boolean
}