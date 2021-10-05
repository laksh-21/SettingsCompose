package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Surface
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
import com.example.datastoresettings.uiComponents.internalComponents.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.launch

@Composable
internal fun SettingsCheckboxComponent(
    modifier: Modifier = Modifier,
    title: String,
    summary: String? = null,
    icon: ImageVector? = null,
    reference: CheckboxReference,
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
            modifier = modifier.fillMaxWidth(),
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
                    Checkbox(checked = value, onCheckedChange = {
                        scope.launch { editValue() }
                    })
                }
            )
        }
    }
}

@Composable
internal fun SettingsCheckboxComponent(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    summary: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    reference: CheckboxReference,
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
            modifier = modifier.fillMaxWidth(1f),
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
                    Checkbox(checked = value, onCheckedChange = {
                        scope.launch { editValue() }
                    })
                }
            )
        }
    }
}

class CheckboxReference(
    key: Preferences.Key<Boolean>,
    defaultValue: Boolean
) : SettingReference<Boolean>(
    key = key,
    defaultValue = defaultValue
)
