package com.example.settingscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.Modifier
import com.example.datastoresettings.uiComponents.SettingsScreen
import com.example.settingscompose.ui.theme.SettingsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsComposeTheme {
                // A surface container using the 'background' color from the theme
                SettingsScreen {
                    SettingsGroup(title = "Group 1") {
                        SettingsCheckbox(
                            modifier = Modifier,
                            title = "Checky Boi",
                            summary = "It go boop boop",
                            icon = Icons.Default.Email
                        )
                        SettingsList(
                            modifier = Modifier,
                            title = "Title",
                            summary = "Summary",
                            icon = Icons.Default.Email,
                            options = listOf("Strings")
                        )
                    }
                }
            }
        }
    }
}
