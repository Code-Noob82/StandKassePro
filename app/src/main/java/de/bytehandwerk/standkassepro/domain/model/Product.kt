package de.bytehandwerk.standkassepro.domain.model

import java.math.BigDecimal

/**
 * Repräsentiert einen Verkaufsartikel.
 */
data class Product(
    val id: String,
    val name: String,
    val price: BigDecimal,
    val categoryId: String? = null
)