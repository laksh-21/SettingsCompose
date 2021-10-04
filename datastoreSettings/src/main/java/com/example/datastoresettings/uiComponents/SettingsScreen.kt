package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen(
    content: @Composable SettingsScreenScope.() -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        SettingsScreenScopeImpl.content()
    }
}

interface SettingsScreenScope {
    @Composable
    fun SettingsCheckbox(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
    )
    @Composable
    fun SettingsCheckbox(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
    )
    @Composable
    fun SettingsSwitch(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
    )
    @Composable
    fun SettingsSwitchComponent(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
    )
    @Composable
    fun SettingsGroup(
        title: String,
        content: @Composable () -> Unit,
    )

    @Composable
    fun SettingsList(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        options: List<String>,
    )
}

internal object SettingsScreenScopeImpl : SettingsScreenScope {
    @Composable
    override fun SettingsCheckbox(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?
    ) {
        SettingsCheckboxComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon
        )
    }

    @Composable
    override fun SettingsCheckbox(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?
    ) {
        SettingsCheckboxComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon
        )
    }

    @Composable
    override fun SettingsSwitch(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?
    ) {
        SettingsSwitchComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
        )
    }

    @Composable
    override fun SettingsSwitchComponent(
        modifier: Modifier,
        title: () -> Unit,
        summary: (() -> Unit)?,
        icon: (() -> Unit)?
    ) {
        SettingsSwitchComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
        )
    }

    @Composable
    override fun SettingsGroup(title: String, content: @Composable () -> Unit) {
        SettingsGroupComponent(title = title, content = content)
    }

    @Composable
    override fun SettingsList(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        options: List<String>
    ) {
        SettingsListComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            options = options,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenDemo() {
    SettingsScreen {
        SettingsCheckbox(
            modifier = Modifier,
            title = "Hi",
            summary = "Summary!",
            icon = Icons.Default.Face
        )
        SettingsGroup(title = "Group 1") {
            SettingsCheckbox(
                modifier = Modifier,
                title = "Hi",
                summary = "Summary!",
                icon = Icons.Default.Face
            )
            SettingsCheckbox(
                modifier = Modifier,
                title = "Hi",
                summary = "Summary!",
                icon = Icons.Default.Face
            )
            SettingsCheckbox(
                modifier = Modifier,
                title = "Hi",
                summary = "Summary!",
                icon = Icons.Default.Face
            )
        }
    }
}
