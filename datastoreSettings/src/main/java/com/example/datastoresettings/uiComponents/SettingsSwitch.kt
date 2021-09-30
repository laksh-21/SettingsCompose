package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SettingsSwitch() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Hello!")
    }
}
