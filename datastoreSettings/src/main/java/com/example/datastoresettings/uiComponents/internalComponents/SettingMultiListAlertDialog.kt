package com.example.datastoresettings.uiComponents.internalComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.datastoresettings.datastoreManager.LocalManagerProvider
import com.example.datastoresettings.uiComponents.MultiListReference
import kotlinx.coroutines.launch

@Composable
internal fun SettingMultiListAlertDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    optionsTitles: List<String>,
    optionsKeys: List<String>,
    reference: MultiListReference
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            text = {
                OptionsList(
                    optionsTitles = optionsTitles,
                    optionsKeys = optionsKeys,
                    reference = reference,
                )
            },
            confirmButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(
                        text = "OK",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(
                        text = "CANCEL",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
        )
    }
}

@Composable
private fun OptionsList(
    optionsTitles: List<String>,
    optionsKeys: List<String>,
    reference: MultiListReference
) {
    val datastoreManager = LocalManagerProvider.current
    val value by datastoreManager.getSettingFlow(reference = reference).collectAsState(initial = null)

    suspend fun setOption(optionKeyValue: String) {
        value?.let {
            val mutableSet: MutableSet<String> = (value as MutableSet<String>).toMutableSet()
            mutableSet.add(optionKeyValue)
            datastoreManager.setSettingValue(reference.key, mutableSet.toSet())
        }
    }

    suspend fun unsetOption(optionKeyValue: String) {
        value?.let {
            val mutableSet: MutableSet<String> = (value as MutableSet<String>).toMutableSet()
            mutableSet.remove(optionKeyValue)
            datastoreManager.setSettingValue(reference.key, mutableSet.toSet())
        }
    }

    LazyColumn {
        optionsTitles.zip(optionsKeys).forEach { (title, key) ->
            item {
                OptionsListItem(
                    optionTitle = title,
                    optionKey = key,
                    selected = value?.contains(key) ?: false,
                    setOption = { setOption(it) },
                    unsetOption = { unsetOption(it) },
                )
            }
        }
    }
}

@Composable
private fun OptionsListItem(
    optionTitle: String,
    optionKey: String,
    selected: Boolean,
    setOption: suspend (String) -> Unit,
    unsetOption: suspend (String) -> Unit,
) {

    val scope = rememberCoroutineScope()

    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    scope.launch {
                        if (!selected) {
                            setOption(optionKey)
                        } else {
                            unsetOption(optionKey)
                        }
                    }
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                DefaultTitleText(title = optionTitle)
            }
            SettingAction {
                Checkbox(checked = selected, onCheckedChange = {
                    scope.launch {
                        if (!selected) {
                            setOption(optionKey)
                        } else {
                            unsetOption(optionKey)
                        }
                    }
                })
            }
        }
    }
}
