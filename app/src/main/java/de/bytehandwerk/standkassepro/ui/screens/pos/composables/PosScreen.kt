package de.bytehandwerk.standkassepro.ui.screens.pos.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.bytehandwerk.standkassepro.ui.screens.pos.PosViewModel

@Composable
fun PosScreen(viewModel: PosViewModel = hiltViewModel()) {
    val products by viewModel.products.collectAsState()
    val cart by viewModel.cart.collectAsState()
    val total by viewModel.totalAmount.collectAsState()

    // Split Screen: Links Produkte (65%), Rechts Warenkorb (35%)
    Row(modifier = Modifier.fillMaxSize()) {
        // Linke Seite: Produkt Grid
        Column(
            modifier = Modifier
                .weight(0.65f)
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(8.dp)
        ) {
            Text("Artikel", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(8.dp))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 120.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(products) { product ->
                    ProductCard(product) { viewModel.addToCart(product) }
                }
            }
        }

        // Rechte Seite: Warenkorb & Checkout
        Column(
            modifier = Modifier
                .weight(0.35f)
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Text("Warenkorb", style = MaterialTheme.typography.headlineMedium)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(cart) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("${item.quantity}x ${item.product.name}")
                        Text("${item.lineTotal} €")
                    }
                }
            }

            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))

            // Summe
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Summe", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
                Text("$total €", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Buttons
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { /* TODO: Bar */ }, modifier = Modifier.weight(1f)) {
                    Text("BAR")
                }
                FilledTonalButton(onClick = { /* TODO: Karte */ }, modifier = Modifier.weight(1f)) {
                    Text("KARTE")
                }
            }
        }
    }
}