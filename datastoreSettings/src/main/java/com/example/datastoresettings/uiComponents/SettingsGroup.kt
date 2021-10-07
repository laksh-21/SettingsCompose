package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.datastoresettings.uiComponents.internalComponents.SettingGroupTitle

/**
 * A wrapper composable to group some Settings together.
 *
 * @param title A title for the group of Settings
 * @param content The composable body of SettingsGroup
 * */
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
