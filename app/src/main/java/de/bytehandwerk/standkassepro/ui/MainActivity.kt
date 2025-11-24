package de.bytehandwerk.standkassepro.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.bytehandwerk.standkassepro.ui.screens.CashRegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CashRegisterScreen() }
    }
}