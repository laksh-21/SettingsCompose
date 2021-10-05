package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
