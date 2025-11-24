package de.bytehandwerk.standkassepro.domain.model

/**
 * Die drei Abo-Stufen der App.
 */
enum class SubscriptionTier(val canAcceptCard: Boolean) {
    BASIC(canAcceptCard = false),     // Kostenlos, nur Bar
    ADVANCED(canAcceptCard = false),  // 4,99€, nur Bar
    PRO(canAcceptCard = true)         // 59,99€, Bar + Karte
}