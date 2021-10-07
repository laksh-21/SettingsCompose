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
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.datastoresettings.datastoreManager.DatastoreManager
import com.example.datastoresettings.uiComponents.* // ktlint-disable no-wildcard-imports
import com.example.settingscompose.References.checkboxReference
import com.example.settingscompose.References.listReference
import com.example.settingscompose.References.multiListReference
import com.example.settingscompose.References.multiOptionsKeys
import com.example.settingscompose.References.multiOptionsTitles
import com.example.settingscompose.References.optionsKeys
import com.example.settingscompose.References.optionsTitles
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
                        SettingsList(
                            modifier = Modifier,
                            title = "Listy Boi",
                            summary = "It go click click",
                            icon = Icons.Default.Email,
                            optionsTitles = optionsTitles,
                            optionsKeys = optionsKeys,
                            reference = listReference
                        )
                        SettingsMultiList(
                            modifier = Modifier,
                            title = "Multi Listy Boi",
                            summary = "It also go Click click",
                            icon = Icons.Default.Email,
                            optionsTitles = multiOptionsTitles,
                            optionsKeys = multiOptionsKeys,
                            reference = multiListReference
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

    val optionsTitles = listOf(
        "Option A",
        "Option B",
        "Option C",
    )
    val optionsKeys = listOf(
        "option_a_key",
        "option_b_key",
        "option_c_key",
    )
    val listReference = ListReference(key = stringPreferencesKey(name = "listBoi"), defaultValue = optionsKeys[0])

    val multiOptionsTitles = listOf(
        "Multi Option A",
        "Multi Option B",
        "Multi Option C",
    )
    val multiOptionsKeys = listOf(
        "multi_options_a_key",
        "multi_options_b_key",
        "multi_options_c_key",
    )
    val multiListReference = MultiListReference(
        key = stringSetPreferencesKey(name = "multiListBoi"),
        defaultValue = setOf(
            multiOptionsKeys[0]
        )
    )
}
