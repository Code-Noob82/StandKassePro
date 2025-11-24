package de.bytehandwerk.standkassepro.domain.model

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Ein Eintrag im Warenkorb.
 */
data class CartItem(
    val product: Product,
    val quantity: Int
) {
    val total: BigDecimal
        get() = product.price.multiply(BigDecimal(quantity))
            .setScale(2, RoundingMode.HALF_UP)
}