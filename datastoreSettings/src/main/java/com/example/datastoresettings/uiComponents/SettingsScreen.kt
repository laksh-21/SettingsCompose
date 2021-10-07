package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.datastoresettings.datastoreManager.DatastoreManager
import com.example.datastoresettings.datastoreManager.LocalManagerProvider

/**
 * A parent composable that encompasses all the other components of the Settings
 * Note that other components cannot be used outside of the [SettingsScreenScope] as the [DatastoreManager] is provided by this composable itself.
 * DatastoreManager is distributed to children composable using [LocalManagerProvider]
 *
 * @param datastoreManager The instance of [DatastoreManager] for the setting DataStore.
 * @param content The body of the [SettingsScreen] composable.
 * */
@Composable
fun SettingsScreen(
    datastoreManager: DatastoreManager,
    content: @Composable SettingsScreenScope.() -> Unit,
) {
    CompositionLocalProvider(LocalManagerProvider provides datastoreManager) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
        ) {
            SettingsScreenScopeImpl.content()
        }
    }
}

/**
 * [SettingsScreenScope] is an interface defining the children composable functions for [SettingsScreen].
 * */
interface SettingsScreenScope {
    /**
     * Defines a default Checkbox setting with predefined text styles.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title for the Setting.
     * @param summary (Optional) The summary for the setting.
     * @param icon (Optional) The leading icon for the setting.
     * @param reference [CheckboxReference] for this setting.
     * */
    @Composable
    fun SettingsCheckbox(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        reference: CheckboxReference,
    )

    /**
     * Defines a Checkbox setting with slots for title, summary and icon.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title composable for the Setting.
     * @param summary (Optional) The summary composable for the setting.
     * @param icon (Optional) The leading icon composable for the setting.
     * @param reference [CheckboxReference] for this setting.
     * */
    @Composable
    fun SettingsCheckbox(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        reference: CheckboxReference,
    )

    /**
     * Defines a default Switch setting with predefined text styles.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title for the Setting.
     * @param summary (Optional) The summary for the setting.
     * @param icon (Optional) The leading icon for the setting.
     * @param reference [CheckboxReference] for this setting.
     * */
    @Composable
    fun SettingsSwitch(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        reference: SwitchReference,
    )

    /**
     * Defines a Switch setting with slots for title, summary and icon.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title composable for the Setting.
     * @param summary (Optional) The summary composable for the setting.
     * @param icon (Optional) The leading icon composable for the setting.
     * @param reference [CheckboxReference] for this setting.
     * */
    @Composable
    fun SettingsSwitch(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        reference: SwitchReference,
    )

    /**
     * Defines a Group wrapper to group settings under a title.
     * @param title The title for the group of Settings
     * @param content The composable body of the [SettingsGroup]
     * */
    @Composable
    fun SettingsGroup(
        title: String,
        content: @Composable () -> Unit,
    )

    /**
     * Defines a default List setting with predefined text styles.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title for the Setting.
     * @param summary (Optional) The summary for the setting.
     * @param icon (Optional) The leading icon for the setting.
     * @param optionsTitles The string [List] of titles for Options.
     * @param optionsKeys The string [List] of keys for Options.
     * @param reference [ListReference] for this setting.
     * */
    @Composable
    fun SettingsList(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: ListReference,
    )

    /**
     * Defines a List setting with slots for title, summary, icon.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title composable for the Setting.
     * @param summary (Optional) The summary composable for the setting.
     * @param icon (Optional) The leading icon composable for the setting.
     * @param optionsTitles The string [List] of titles for Options.
     * @param optionsKeys The string [List] of keys for Options.
     * @param reference [ListReference] for this setting.
     * */
    @Composable
    fun SettingsList(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: ListReference,
    )

    /**
     * Defines a default MultiSelectList setting with predefined text styles.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title for the Setting.
     * @param summary (Optional) The summary for the setting.
     * @param icon (Optional) The leading icon for the setting.
     * @param optionsTitles The string [List] of titles for Options.
     * @param optionsKeys The string [List] of keys for Options.
     * @param reference [MultiListReference] for this setting.
     * */
    @Composable
    fun SettingsMultiList(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: MultiListReference,
    )

    /**
     * Defines a MultiSelectList setting with slots for title, summary, icon.
     * @param modifier The modifier for the row containing setting info.
     * @param title The title composable for the Setting.
     * @param summary (Optional) The summary composable for the setting.
     * @param icon (Optional) The leading icon composable for the setting.
     * @param optionsTitles The string [List] of titles for Options.
     * @param optionsKeys The string [List] of keys for Options.
     * @param reference [MultiListReference] for this setting.
     * */
    @Composable
    fun SettingsMultiList(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: MultiListReference,
    )
}

/**
 * [SettingsScreenScopeImpl] implements the [SettingsScreenScope] interface.
 * */
internal object SettingsScreenScopeImpl : SettingsScreenScope {
    @Composable
    override fun SettingsCheckbox(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        reference: CheckboxReference,
    ) {
        SettingsCheckboxComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            reference = reference,
        )
    }

    @Composable
    override fun SettingsCheckbox(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        reference: CheckboxReference,
    ) {
        SettingsCheckboxComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            reference = reference,
        )
    }

    @Composable
    override fun SettingsSwitch(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        reference: SwitchReference
    ) {
        SettingsSwitchComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            reference = reference,
        )
    }

    @Composable
    override fun SettingsSwitch(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        reference: SwitchReference,
    ) {
        SettingsSwitchComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            reference = reference,
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
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: ListReference,
    ) {
        SettingsListComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            optionsTitles = optionsTitles,
            optionsKeys = optionsKeys,
            reference = reference,
        )
    }

    @Composable
    override fun SettingsList(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: ListReference
    ) {
        SettingsListComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            optionsTitles = optionsTitles,
            optionsKeys = optionsKeys,
            reference = reference,
        )
    }

    @Composable
    override fun SettingsMultiList(
        modifier: Modifier,
        title: String,
        summary: String?,
        icon: ImageVector?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: MultiListReference
    ) {
        SettingsMultiListComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            optionsTitles = optionsTitles,
            optionsKeys = optionsKeys,
            reference = reference
        )
    }

    @Composable
    override fun SettingsMultiList(
        modifier: Modifier,
        title: @Composable () -> Unit,
        summary: @Composable (() -> Unit)?,
        icon: @Composable (() -> Unit)?,
        optionsTitles: List<String>,
        optionsKeys: List<String>,
        reference: MultiListReference
    ) {
        SettingsMultiListComponent(
            modifier = modifier,
            title = title,
            summary = summary,
            icon = icon,
            optionsTitles = optionsTitles,
            optionsKeys = optionsKeys,
            reference = reference
        )
    }
}
