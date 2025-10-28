package de.bytehandwerk.standkassepro.data.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.ds by preferencesDataStore("taschenkasse_settings")
private val KEY_ARTICLES = stringPreferencesKey("articles_json")

class SettingsStore(private val context: Context) {
    fun articlesFlow() = context.ds.data.map { it[KEY_ARTICLES].orEmpty() }
    suspend fun saveArticles(json: String) = context.ds.edit { it[KEY_ARTICLES] = json }
    suspend fun getArticlesOnce() = context.ds.data.first()[KEY_ARTICLES].orEmpty()
}