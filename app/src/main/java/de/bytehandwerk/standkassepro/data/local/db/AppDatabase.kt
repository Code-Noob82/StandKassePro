package de.bytehandwerk.standkassepro.data.local.db

import de.bytehandwerk.standkassepro.data.local.db.converters.BigDecimalConverter
import de.bytehandwerk.standkassepro.data.local.entity.ProductEntity

// Hinweis: Du müsstest auch SaleEntity analog zu ProductEntity erstellen
@Database(entities = [ProductEntity::class /*, SaleEntity::class*/], version = 1)
@TypeConverters(BigDecimalConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    // abstract fun saleDao(): SaleDao
}