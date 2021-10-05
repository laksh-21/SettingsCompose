package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.datastore.preferences.core.Preferences
import com.example.datastoresettings.datastoreManager.LocalManagerProvider
import com.example.datastoresettings.datastoreManager.SettingReference
import com.example.datastoresettings.uiComponents.internalComponents.DefaultSummaryText
import com.example.datastoresettings.uiComponents.internalComponents.DefaultTitleText
import com.example.datastoresettings.uiComponents.internalComponents.SettingAction
import com.example.datastoresettings.uiComponents.internalComponents.SettingDescription
import com.example.datastoresettings.uiComponents.internalComponents.SettingIcon
import kotlinx.coroutines.launch

@Composable
internal fun SettingsSwitchComponent(
    modifier: Modifier = Modifier,
    title: String,
    summary: String? = null,
    icon: ImageVector? = null,
    reference: SwitchReference,
) {
    val datastoreManager = LocalManagerProvider.current
    val value: Boolean by datastoreManager
        .getSettingFlow(reference = reference)
        .collectAsState(initial = false)

    suspend fun editValue() {
        datastoreManager.setSettingValue(reference.key, value = !value)
    }

    val scope = rememberCoroutineScope()

    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { scope.launch { editValue() } },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                SettingIcon(icon = { Icon(imageVector = icon, contentDescription = "Icon") })
            }
            SettingDescription(
                title = { DefaultTitleText(title = title) },
                {
                    summary?.let {
                        DefaultSummaryText(summary = summary)
                    }
                }
            )
            SettingAction(
                action = {
                    Switch(checked = value, onCheckedChange = {
                        scope.launch { editValue() }
                    })
                }
            )
        }
    }
}

@Composable
internal fun SettingsSwitchComponent(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    summary: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    reference: SwitchReference,
) {
    val datastoreManager = LocalManagerProvider.current
    val value: Boolean by datastoreManager
        .getSettingFlow(reference = reference)
        .collectAsState(initial = false)

    suspend fun editValue() {
        datastoreManager.setSettingValue(reference.key, value = !value)
    }

    val scope = rememberCoroutineScope()

    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { scope.launch { editValue() } },
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                SettingIcon(icon = icon)
            }
            SettingDescription(
                title = title,
                summary = summary
            )
            SettingAction(
                action = {
                    Switch(checked = value, onCheckedChange = {
                        scope.launch { editValue() }
                    })
                }
            )
        }
    }
}

class SwitchReference(
    key: Preferences.Key<Boolean>,
    defaultValue: Boolean
) : SettingReference<Boolean>(
    key = key,
    defaultValue = defaultValue
)
