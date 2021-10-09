package com.example.datastoresettings.datastoreManager

import androidx.compose.runtime.compositionLocalOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DatastoreManager(private val datastore: DataStore<Preferences>) {
    private val dataFlow = datastore.data

    /**
     * Returns a Flow for the given [SettingReference]
     *
     * @param reference The [SettingReference] for the Setting
     * @return the Flow for the setting, defaultValue if it does not exist.
     * */
    fun <T> getSettingFlow(reference: SettingReference<T>) =
        dataFlow.map { preference ->
            preference[reference.key] ?: reference.defaultValue
        }

    /**
     * Returns a value of type [T] for the given [SettingReference]
     *
     * @param reference The [SettingReference] for the setting
     * @return The value for the setting, defaultValue if it does not exist.
     * */
    suspend fun <T> getSettingValue(reference: SettingReference<T>) =
        dataFlow.first()[reference.key] ?: reference.defaultValue

    /**
     * Sets the value for a Setting
     *
     * @param key The [Preferences.Key] for the Setting you want to set.
     * @param value The value that we you want to set for this setting.
     * */
    suspend fun <T> setSettingValue(key: Preferences.Key<T>, value: T) {
        datastore.edit { preference ->
            preference[key] = value
        }
    }
}

/**
 * A Local composition provider to Provide the [DatastoreManager]
 * */
val LocalManagerProvider = compositionLocalOf<DatastoreManager> {
    error("No ManagerProvided")
}

/**
 * A general purpose reference for a Setting
 *
 * @param key The [Preferences.Key] for the setting.
 * @param defaultValue The default value for the setting.
 * */
open class SettingReference<T>(
    val key: Preferences.Key<T>,
    val defaultValue: T,
)
