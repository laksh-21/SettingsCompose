package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.datastoresettings.uiComponents.internalComponents.DefaultSummaryText
import com.example.datastoresettings.uiComponents.internalComponents.DefaultTitleText
import com.example.datastoresettings.uiComponents.internalComponents.SettingAction
import com.example.datastoresettings.uiComponents.internalComponents.SettingDescription
import com.example.datastoresettings.uiComponents.internalComponents.SettingIcon

@Composable
internal fun SettingsSwitchComponent(
    modifier: Modifier = Modifier,
    title: String,
    summary: String? = null,
    icon: ImageVector? = null,
) {
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
                    Switch(checked = true, onCheckedChange = {})
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
) {
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
                    Switch(checked = true, onCheckedChange = {})
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicSwitch() {
    SettingsSwitchComponent(
        title = "Hello!",
        summary = "Summary..",
        icon = Icons.Filled.ArrowBack
    )
}
