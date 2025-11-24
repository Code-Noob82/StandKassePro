package de.bytehandwerk.standkassepro.data.local.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import de.bytehandwerk.standkassepro.domain.model.SubscriptionTier
import de.bytehandwerk.standkassepro.domain.repository.BillingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// --- Repository Implementation (Mock für Billing) ---
/**
 * Verwaltet Google Play Billing und cached das Ergebnis für Offline-Nutzung.
 */
class OfflineFirstBillingRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
    // In der Realität: private val billingClient: BillingClient
) : BillingRepository {

    private val SUB_TIER_KEY = stringPreferencesKey("subscription_tier")

    // Mapping von Billing IDs zu unserem Domain Enum
    // basic_plan_id -> SubscriptionTier.BASIC
    // pro_plan_id -> SubscriptionTier.PRO

    override val currentSubscriptionTier: Flow<SubscriptionTier> = dataStore.data
        .map { preferences ->
            val tierName = preferences[SUB_TIER_KEY] ?: SubscriptionTier.BASIC.name
            try {
                SubscriptionTier.valueOf(tierName)
            } catch (e: IllegalArgumentException) {
                SubscriptionTier.BASIC
            }
        }

    override suspend fun launchUpgradeFlow(targetTier: SubscriptionTier) {
        // Hier würde der echte Google Play Billing Flow starten
        // Bei Erfolg würde das Ergebnis in den DataStore geschrieben werden:
        // preferences.edit { it[SUB_TIER_KEY] = targetTier.name }
    }
}