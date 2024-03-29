package com.conny.blog.model.request.post

import com.conny.blog.model.entity.PostEntity

data class PostRequest(
    var title: String? = null,
    var description: String? = null,
    var attachment: String? = null,
    var categoryId: String? = null,
) {
    fun toEntity(): PostEntity {
        return PostEntity(
            title = this.title,
            description = this.description,
            attachment = this.attachment
        )
    }
}