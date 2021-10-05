package com.example.datastoresettings.uiComponents.internalComponents

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun SettingListAlertDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    options: List<String>,
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Text(text = "Title")
            },
            text = { OptionsList(options = options) },
            confirmButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(
                        text = "OK",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
        )
    }
}

@Composable
private fun OptionsList(options: List<String>) {
    LazyColumn {
        options.forEach { option ->
            item {
                OptionsListItem(option = option)
            }
        }
    }
}

@Composable
private fun OptionsListItem(option: String) {
    Surface {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                DefaultTitleText(title = option)
            }
            SettingAction {
                RadioButton(selected = true, onClick = { })
            }
        }
    }
}
