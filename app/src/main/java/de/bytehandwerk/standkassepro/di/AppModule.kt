package de.bytehandwerk.standkassepro.di

import android.app.Application
import de.bytehandwerk.standkassepro.data.local.db.AppDatabase
import de.bytehandwerk.standkassepro.data.local.db.ProductDao
import de.bytehandwerk.standkassepro.data.repository.ProductRepositoryImpl
import de.bytehandwerk.standkassepro.domain.repository.ProductRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "standkasse_pro.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase): ProductDao = db.productDao()

    @Provides
    @Singleton
    fun provideProductRepository(dao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(dao)
    }
}