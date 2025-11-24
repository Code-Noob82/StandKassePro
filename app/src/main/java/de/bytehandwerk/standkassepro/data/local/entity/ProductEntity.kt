package de.bytehandwerk.standkassepro.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: String,
    val name: String,
    val price: String, // Gespeichert als String für BigDecimal Präzision
    val categoryId: String?
)