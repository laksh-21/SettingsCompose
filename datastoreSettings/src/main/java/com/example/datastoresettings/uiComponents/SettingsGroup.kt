package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.datastoresettings.uiComponents.internalComponents.SettingGroupTitle

@Composable
fun SettingsGroup(
    title: String,
    content: @Composable () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SettingGroupTitle(title = title)
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingGroupDemo() {
    SettingsGroup(title = "Demos") {
        BasicCheckbox()
    }
}
