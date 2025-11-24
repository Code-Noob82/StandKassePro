package de.bytehandwerk.standkassepro.domain.usecase

import de.bytehandwerk.standkassepro.domain.model.PaymentMethod
import de.bytehandwerk.standkassepro.domain.model.SubscriptionTier
import javax.inject.Inject

/**
 * Validiert, ob eine Zahlungsmethode für das aktuelle Abo erlaubt ist.
 */
class ValidatePaymentMethodUseCase @Inject constructor() {
    operator fun invoke(tier: SubscriptionTier, method: PaymentMethod): Boolean {
        return when (method) {
            PaymentMethod.CASH -> true // Immer erlaubt
            PaymentMethod.CARD -> tier.canAcceptCard // Nur im PRO Plan erlaubt
        }
    }
}