package de.bytehandwerk.standkassepro.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import de.bytehandwerk.standkassepro.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>
}