package com.example.settingscompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.datastoresettings.datastoreManager.DatastoreManager
import com.example.datastoresettings.uiComponents.CheckboxReference
import com.example.datastoresettings.uiComponents.SettingsScreen
import com.example.datastoresettings.uiComponents.SwitchReference
import com.example.settingscompose.References.checkboxReference
import com.example.settingscompose.References.switchReference
import com.example.settingscompose.ui.theme.SettingsComposeTheme

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val datastoreManager = DatastoreManager(datastore = this.datastore)
        setContent {
            SettingsComposeTheme {
                SettingsScreen(datastoreManager = datastoreManager) {
                    SettingsGroup(title = "Group 1") {
                        SettingsCheckbox(
                            modifier = Modifier,
                            title = "Checky Boi",
                            summary = "It go boop boop",
                            icon = Icons.Default.Email,
                            reference = checkboxReference,
                        )
                        SettingsSwitch(
                            modifier = Modifier,
                            title = "Switchy Boi",
                            summary = "It go switch switch",
                            icon = Icons.Default.Email,
                            reference = switchReference,
                        )
                    }
                }
            }
        }
    }
}

object References {
    val checkboxReference = CheckboxReference(key = booleanPreferencesKey(name = "checkBoi"), defaultValue = false)
    val switchReference = SwitchReference(key = booleanPreferencesKey(name = "switchBoi"), defaultValue = false)
}
