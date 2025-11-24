package de.bytehandwerk.standkassepro.domain.usecase

import de.bytehandwerk.standkassepro.domain.model.CartItem
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

/**
 * Berechnet die Summe des Warenkorbs.
 */
class CalculateCartTotalUseCase @Inject constructor() {
    operator fun invoke(items: List<CartItem>): BigDecimal {
        return items.fold(BigDecimal.ZERO) { acc, item ->
            acc.add(item.total)
        }.setScale(2, RoundingMode.HALF_UP)
    }
}