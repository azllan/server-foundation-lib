package org.azllan.server.foundation.application.transfers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

abstract class DataTransfer {
    companion object {
        const val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
    }

    abstract val id: UUID?
    abstract val createdAt: LocalDateTime?
    abstract val updatedAt: LocalDateTime?
    abstract val deletedAt: LocalDateTime?

    fun getFormattedCreatedAt() = createdAt?.format(
        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
    )

    fun getFormattedUpdatedAt() = updatedAt?.format(
        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
    )

    fun getFormattedDeletedAt() = deletedAt?.format(
        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
    )
}