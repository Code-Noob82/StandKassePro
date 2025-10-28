package de.bytehandwerk.standkassepro.data.repo

import de.bytehandwerk.standkassepro.data.model.article.Article
import de.bytehandwerk.standkassepro.data.store.SettingsStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ArticleRepository(
    private val store: SettingsStore
) {

    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = false
    }

    /** Gibt alle Artikel zurück, neu geladen als Flow. */
    fun articles(): Flow<List<Article>> =
        store.articlesFlow().map { rawJson ->
            if (rawJson.isBlank()) {
                defaultArticles()
            } else {
                runCatching {
                    json.decodeFromString<List<Article>>(rawJson)
                }.getOrElse {
                    defaultArticles()
                }
            }
        }

    /** Speichert die komplette Artikel-Liste. */
    suspend fun save(articles: List<Article>) {
        val encoded = json.encodeToString(articles)
        store.saveArticles(encoded)
    }

    /** Liefert eine Standardliste (z. B. initial) */
    private fun defaultArticles(): List<Article> =
        List(20) { index ->
            Article(
                id = index,
                name = "Artikel ${index + 1}",
                priceCents = 0L
            )
        }
}