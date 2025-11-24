package de.bytehandwerk.standkassepro.ui.components

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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.bytehandwerk.standkassepro.domain.model.PaymentMethod
import de.bytehandwerk.standkassepro.domain.model.SubscriptionTier
import de.bytehandwerk.standkassepro.ui.pos.POSViewModel
import de.bytehandwerk.standkassepro.ui.screens.pos.composables.ProductCard

@Composable
fun POSScreen(
    viewModel: POSViewModel,
    onNavigateToUpgrade: () -> Unit
) {
    val products by viewModel.products.collectAsState()
    val cart by viewModel.cart.collectAsState()
    val total by viewModel.cartTotal.collectAsState()
    val tier by viewModel.subscriptionTier.collectAsState()

    Row(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        // LINKER BEREICH: Produkte (60%)
        Column(modifier = Modifier.weight(0.6f).padding(16.dp)) {
            Text("Artikel", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(products) { product ->
                    ProductCard(product) { viewModel.addToCart(product) }
                }
            }
        }

        // RECHTER BEREICH: Warenkorb & Checkout (40%)
        Column(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(16.dp)
        ) {
            Text("Warenkorb", style = MaterialTheme.typography.headlineSmall)

            // Abo-Badge
            SuggestionChip(
                onClick = { onNavigateToUpgrade() },
                label = { Text("Plan: ${tier.name}") },
                colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = if(tier == SubscriptionTier.PRO) Color.Green.copy(alpha=0.2f) else Color.Gray.copy(alpha=0.2f)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Cart List
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(cart) { item ->
                    CartItemRow(item)
                }
            }

            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))

            // Summe
            Text(
                text = "Summe: ${total.toPlainString()} €",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Checkout Buttons
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // BARZAHLUNG (Immer aktiv)
                Button(
                    onClick = { viewModel.onCheckout(PaymentMethod.CASH) },
                    modifier = Modifier.weight(1f).height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text("BAR")
                }

                // KARTENZAHLUNG (Nur PRO)
                val isCardEnabled = tier == SubscriptionTier.PRO
                Button(
                    onClick = {
                        if (isCardEnabled) viewModel.onCheckout(PaymentMethod.CARD)
                        else onNavigateToUpgrade()
                    },
                    modifier = Modifier.weight(1f).height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isCardEnabled) Color(0xFF2196F3) else Color.Gray
                    )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("KARTE")
                        if (!isCardEnabled) {
                            Text("(Nur PRO)", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }
    }
}