package com.conny.blog.property

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class StorageProperties(
    @Value("\${conny.storage.uri:files}")
    private val storageUri: String,
    private val appProperties: AppProperties,
) {
    fun getFullStoragePath(): String {
        return "${appProperties.getApiOrigin()}${getStorageUriPath()}"
    }

    fun getStorageUriPath(): String {
        return "/$storageUri"
    }

    fun getFileStorageDirectory(): String {
        return appProperties.getFilePath()
    }
}