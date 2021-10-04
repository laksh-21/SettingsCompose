package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.datastoresettings.uiComponents.internalComponents.* // ktlint-disable no-wildcard-imports

@Composable
internal fun SettingsListComponent(
    modifier: Modifier = Modifier,
    title: String,
    summary: String? = null,
    icon: ImageVector? = null,
    options: List<String>,
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
        options = options
    )
}

@Preview
@Composable
private fun ListDemo() {
    SettingsListComponent(
        title = "Title Boi",
        options = listOf("hoi!"),
        icon = Icons.Default.Email,
    )
}
