package de.bytehandwerk.standkassepro.data.model.cartItem

import de.bytehandwerk.standkassepro.data.model.article.Article

/**
 * Repräsentiert einen Eintrag im Warenkorb.
 *
 * @property article Der Artikel, der gebucht wurde.
 * @property quantity Die Menge dieses Artikels.
 */
data class CartItem(
    val article: Article,
    val quantity: Int
) {
    /** Gesamtpreis dieses Eintrags in Cent */
    val totalCents: Long
        get() = article.priceCents * quantity
}
