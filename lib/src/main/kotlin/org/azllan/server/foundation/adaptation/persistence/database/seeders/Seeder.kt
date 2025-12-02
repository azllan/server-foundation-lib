package org.azllan.server.foundation.adaptation.persistence.database.seeders

interface Seeder : Comparable<Seeder> {
    val order: Int

    fun seed()

    override fun compareTo(other: Seeder): Int = order - other.order
}