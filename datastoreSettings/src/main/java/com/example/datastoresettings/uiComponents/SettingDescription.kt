package com.example.datastoresettings.uiComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun RowScope.SettingDescription(
    title: @Composable () -> Unit,
    summary: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        title()
        if (summary != null) {
            summary()
        }
    }
}

@Composable
internal fun DefaultTitleText(title: String) {
    Text(
        text = title,
        maxLines = 1,
    )
}

@Composable
internal fun DefaultSummaryText(summary: String) {
    Text(
        text = summary,
        color = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
    )
}
