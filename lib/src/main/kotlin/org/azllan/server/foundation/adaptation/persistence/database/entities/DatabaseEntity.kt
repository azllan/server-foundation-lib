package org.azllan.server.foundation.adaptation.persistence.database.entities

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist

import java.time.LocalDateTime
import java.util.UUID

import com.github.f4b6a3.uuid.UuidCreator

@MappedSuperclass
abstract class DatabaseEntity {
    abstract var id: UUID?
    abstract var createdAt: LocalDateTime?
    abstract var updatedAt: LocalDateTime?
    abstract var deletedAt: LocalDateTime?

    @PrePersist
    fun generateId() {
        if (id == null) {
            id = UuidCreator.getTimeOrderedEpoch()
        }
    }
}