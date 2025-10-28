package de.bytehandwerk.standkassepro.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.bytehandwerk.standkassepro.data.model.article.Article
import de.bytehandwerk.standkassepro.data.model.cartItem.CartItem
import de.bytehandwerk.standkassepro.data.repo.ArticleRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CashRegisterViewModel(private val repo: ArticleRepository) : ViewModel() {

    val articles = repo.articles().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart = _cart.asStateFlow()
    val totalInCents = _cart.map { it.sumOf { it.totalCents } }
        .stateIn(viewModelScope, SharingStarted.Eagerly, 0L)

    fun addArticleToCart(article: Article, qty: Int = 1) {
        val newCart = _cart.value.toMutableList()
        val index = newCart.indexOfFirst { it.article.id == article.id }
        if (index >= 0) newCart[index] = newCart[index].copy(quantity = newCart[index].quantity + qty)
        else newCart.add(CartItem(article, qty))
        _cart.value = newCart
    }

    fun resetCart() = viewModelScope.launch { _cart.value = emptyList() }
}