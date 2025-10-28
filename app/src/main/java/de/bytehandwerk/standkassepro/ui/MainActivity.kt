package de.bytehandwerk.standkassepro.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.bytehandwerk.taschenkasse.ui.screen.CashRegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CashRegisterScreen() }
    }
}