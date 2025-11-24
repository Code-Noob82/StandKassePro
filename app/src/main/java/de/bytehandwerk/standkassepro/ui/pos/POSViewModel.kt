package de.bytehandwerk.standkassepro.ui.pos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.bytehandwerk.standkassepro.domain.model.CartItem
import de.bytehandwerk.standkassepro.domain.model.PaymentMethod
import de.bytehandwerk.standkassepro.domain.model.Product
import de.bytehandwerk.standkassepro.domain.model.SubscriptionTier
import de.bytehandwerk.standkassepro.domain.repository.BillingRepository
import de.bytehandwerk.standkassepro.domain.repository.ProductRepository
import de.bytehandwerk.standkassepro.domain.usecase.CalculateCartTotalUseCase
import de.bytehandwerk.standkassepro.domain.usecase.ValidatePaymentMethodUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class POSViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val billingRepository: BillingRepository,
    private val calculateTotal: CalculateCartTotalUseCase,
    private val validatePayment: ValidatePaymentMethodUseCase
) : ViewModel() {

    // UI State
    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart = _cart.asStateFlow()

    val products = productRepository.getAllProducts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val subscriptionTier = billingRepository.currentSubscriptionTier
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SubscriptionTier.BASIC)

    val cartTotal: StateFlow<BigDecimal> = _cart.map { calculateTotal(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), BigDecimal.ZERO)

    // Events
    fun addToCart(product: Product) {
        val currentList = _cart.value.toMutableList()
        val existingItem = currentList.find { it.product.id == product.id }

        if (existingItem != null) {
            val index = currentList.indexOf(existingItem)
            currentList[index] = existingItem.copy(quantity = existingItem.quantity + 1)
        } else {
            currentList.add(CartItem(product, 1))
        }
        _cart.value = currentList
    }

    fun clearCart() {
        _cart.value = emptyList()
    }

    fun onCheckout(method: PaymentMethod) {
        val currentTier = subscriptionTier.value
        if (validatePayment(currentTier, method)) {
            // Führe Transaktion durch
            clearCart()
            // Hier Navigation zur Erfolgsseite oder Toast
        } else {
            // Trigger Upgrade Dialog (UI Event)
        }
    }
}