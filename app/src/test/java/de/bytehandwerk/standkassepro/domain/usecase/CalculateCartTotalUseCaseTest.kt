package de.bytehandwerk.standkassepro.domain.usecase

import de.bytehandwerk.standkassepro.domain.model.CartItem
import de.bytehandwerk.standkassepro.domain.model.Product
import org.junit.Test
import java.math.BigDecimal

class CalculateCartTotalUseCaseTest {

    private val useCase = CalculateCartTotalUseCase()

    @Test
    fun `calculate total sums up correctly`() {
        val p1 =
            Product(name = "Bier", price = BigDecimal("4.50"), colorHex = "#000", iconName = "")
        val p2 =
            Product(name = "Wurst", price = BigDecimal("3.20"), colorHex = "#000", iconName = "")

        val items = listOf(
            CartItem(p1, 2), // 9.00
            CartItem(p2, 1)  // 3.20
        )

        val result = useCase(items)

        // Erwartet: 12.20
        assert(result.compareTo(BigDecimal("12.20")) == 0)
    }
}