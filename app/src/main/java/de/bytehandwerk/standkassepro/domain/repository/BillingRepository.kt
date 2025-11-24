package de.bytehandwerk.standkassepro.domain.repository

import de.bytehandwerk.standkassepro.domain.model.SubscriptionTier
import kotlinx.coroutines.flow.Flow

interface BillingRepository {
    /**
     * Beobachtet den aktuellen Abo-Status.
     * Muss Offline funktionieren (cached via DataStore).
     */
    val currentSubscriptionTier: Flow<SubscriptionTier>

    suspend fun launchUpgradeFlow(targetTier: SubscriptionTier)
}