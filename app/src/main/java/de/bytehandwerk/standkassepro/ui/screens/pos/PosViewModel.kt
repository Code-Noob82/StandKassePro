package de.bytehandwerk.standkassepro.ui.screens.pos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.bytehandwerk.standkassepro.domain.model.CartItem
import de.bytehandwerk.standkassepro.domain.model.Product
import de.bytehandwerk.standkassepro.domain.repository.ProductRepository
import de.bytehandwerk.standkassepro.domain.usecase.CalculateCartTotalUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import java.math.BigDecimal

@HiltViewModel
class PosViewModel @Inject constructor(
    repository: ProductRepository,
    private val calculateTotalUseCase: CalculateCartTotalUseCase
) : ViewModel() {

    val products = repository.getAllProducts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart: StateFlow<List<CartItem>> = _cart

    // Berechneter State: Summe
    val totalAmount: StateFlow<BigDecimal> = _cart.combine(_cart) { items, _ ->
        calculateTotalUseCase(items)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), BigDecimal.ZERO)

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

    // Todo: implement checkout (save to DB)
}