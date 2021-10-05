package com.example.datastoresettings.datastoreManager

import androidx.compose.runtime.compositionLocalOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map

class DatastoreManager(private val datastore: DataStore<Preferences>) {
    private val dataFlow = datastore.data

    fun <T> getSettingFlow(reference: SettingReference<T>) =
        dataFlow.map { preference ->
            preference[reference.key] ?: reference.defaultValue
        }

    suspend fun <T> setSettingValue(key: Preferences.Key<T>, value: T) {
        datastore.edit { preference ->
            preference[key] = value
        }
    }
}

val LocalManagerProvider = compositionLocalOf<DatastoreManager> {
    error("No ManagerProvided")
}

open class SettingReference<T>(
    val key: Preferences.Key<T>,
    val defaultValue: T,
)
