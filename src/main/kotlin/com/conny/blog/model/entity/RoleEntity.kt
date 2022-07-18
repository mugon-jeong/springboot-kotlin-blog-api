package com.conny.blog.model.entity

import com.conny.blog.constant.TableConstant
import com.conny.blog.infrastructure.model.entity.BaseEntity
import javax.persistence.*

@Entity
@Table(name = TableConstant.ROLE)
open class RoleEntity constructor(
    @Column(length = 30, nullable = false)
    open var name: String? = null,
    @Column(length = 50)
    open var notes: String? = null,

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.DETACH, CascadeType.REFRESH],
        mappedBy = "roles"
    )
    open var users: MutableList<UserEntity>? = mutableListOf(),


    ) : BaseEntity<Long>()