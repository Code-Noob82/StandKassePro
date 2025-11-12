package de.bytehandwerk.standkassepro.data.model.article

import kotlinx.serialization.Serializable

/**
 * Repräsentiert einen Artikel für die Stand-Kasse.
 *
 * @property id Eindeutige Artikel-ID.
 * @property name Name des Artikels (z. B. „Bier“, „Bratwurst“).
 * @property priceCents Preis in Cent (z. B. 350 = 3,50 €).
 */
@Serializable
data class Article(
    val id: Int,
    val name: String,
    val priceCents: Long
)