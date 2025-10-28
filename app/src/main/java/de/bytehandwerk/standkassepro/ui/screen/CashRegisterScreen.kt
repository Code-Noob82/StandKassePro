package de.bytehandwerk.standkassepro.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.bytehandwerk.standkassepro.viewModel.CashRegisterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CashRegisterScreen(viewModel: CashRegisterViewModel = koinViewModel()) {
    val articles by viewModel.articles.collectAsState(initial = emptyList())
    val cart by viewModel.cart.collectAsState(initial = emptyList())
    val total by viewModel.totalInCents.collectAsState(initial = 0L)

    Row(Modifier.fillMaxSize().padding(8.dp)) {
        // später: ArticleGrid(), CartList(), CheckoutArea()
    }
}