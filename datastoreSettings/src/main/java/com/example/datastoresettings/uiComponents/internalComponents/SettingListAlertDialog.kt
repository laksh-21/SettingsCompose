package com.example.datastoresettings.uiComponents.internalComponents

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

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
            text = {
                Text(
                    "This area typically contains the supportive text " +
                        "which presents the details regarding the Dialog's purpose."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { onDismiss() }
                ) {
                    Text("Ok")
                }
            },
        )
    }
}
