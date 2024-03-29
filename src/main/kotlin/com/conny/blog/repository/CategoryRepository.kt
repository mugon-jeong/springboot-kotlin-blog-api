package com.conny.blog.repository

import com.conny.blog.model.entity.CategoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<CategoryEntity, Long> {
    fun existsByNameAndDeletedAtIsNull(name: String): Boolean

    fun queryByIdAndDeletedAtIsNull(id: Long): CategoryEntity?

    fun queryAllByDeletedAtIsNull(): MutableList<CategoryEntity>

    fun queryAllByDeletedAtIsNull(pageable: Pageable): Page<CategoryEntity>
}