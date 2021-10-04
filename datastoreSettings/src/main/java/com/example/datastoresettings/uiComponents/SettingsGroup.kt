package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.datastoresettings.uiComponents.internalComponents.SettingGroupTitle

@Composable
internal fun SettingsGroupComponent(
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
private fun SettingGroupDemo() {
    SettingsGroupComponent(title = "Demos") {
        SettingsCheckboxComponent(
            title = "Hello!",
            summary = "Summary",
            icon = Icons.Default.Favorite
        )
        SettingsCheckboxComponent(
            title = "Hello!",
            summary = "Summary",
            icon = Icons.Default.Favorite
        )
        SettingsCheckboxComponent(
            title = "Hello!",
            summary = "Summary",
            icon = Icons.Default.Favorite
        )
    }
}
