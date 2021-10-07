package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.datastore.preferences.core.Preferences
import com.example.datastoresettings.datastoreManager.SettingReference
import com.example.datastoresettings.uiComponents.internalComponents.* // ktlint-disable no-wildcard-imports

@Composable
internal fun SettingsListComponent(
    modifier: Modifier = Modifier,
    title: String,
    summary: String? = null,
    icon: ImageVector? = null,
    optionsTitles: List<String>,
    optionsKeys: List<String>,
    reference: ListReference,
) {
    val showDialog = remember { mutableStateOf(false) }

    fun onClickRow() {
        showDialog.value = true
    }

    fun onDismiss() {
        showDialog.value = false
    }

    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClickRow() },
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
        }
    }
    SettingListAlertDialog(
        showDialog = showDialog.value,
        onDismiss = { onDismiss() },
        optionsTitles = optionsTitles,
        optionsKeys = optionsKeys,
        reference = reference,
    )
}

@Composable
internal fun SettingsListComponent(
    modifier: Modifier,
    title: @Composable () -> Unit,
    summary: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    optionsTitles: List<String>,
    optionsKeys: List<String>,
    reference: ListReference,
) {
    val showDialog = remember { mutableStateOf(false) }

    fun onClickRow() {
        showDialog.value = true
    }

    fun onDismiss() {
        showDialog.value = false
    }

    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClickRow() },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                SettingIcon(icon = icon)
            }
            SettingDescription(
                title = title,
                summary = summary,
            )
        }
    }
    SettingListAlertDialog(
        showDialog = showDialog.value,
        onDismiss = { onDismiss() },
        optionsTitles = optionsTitles,
        optionsKeys = optionsKeys,
        reference = reference,
    )
}

/**
 * Extends [SettingReference] to define a reference to a List Setting.
 *
 * @param key A [String] [Preferences.Key] for this setting
 * @param defaultValue A [String] value for when the datastore does not contain given setting.
 * */
class ListReference(
    key: Preferences.Key<String>,
    defaultValue: String
) : SettingReference<String>(
    key = key,
    defaultValue = defaultValue
)
