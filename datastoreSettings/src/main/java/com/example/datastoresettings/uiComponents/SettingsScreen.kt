package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen(
    content: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxSize()
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenDemo() {
    SettingsScreen {
        SettingsGroup(title = "Demos") {
            BasicCheckbox()
            BasicSwitch()
            BasicCheckbox()
            BasicSwitch()
        }
    }
}
