package de.bytehandwerk.standkassepro.domain.repository

import de.bytehandwerk.standkassepro.domain.model.CartItem
import de.bytehandwerk.standkassepro.domain.model.PaymentMethod
import java.math.BigDecimal

interface TransactionRepository {
    suspend fun saveTransaction(items: List<CartItem>, total: BigDecimal, method: PaymentMethod)
}