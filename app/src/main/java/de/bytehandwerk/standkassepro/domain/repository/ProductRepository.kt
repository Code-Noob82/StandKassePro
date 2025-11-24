package de.bytehandwerk.standkassepro.domain.repository

import de.bytehandwerk.standkassepro.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(): Flow<List<Product>>
    suspend fun getProductById(id: String): Product?
}