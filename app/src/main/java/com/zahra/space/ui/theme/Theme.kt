package com.zahra.space.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = IslamicGreen,
    secondary = IslamicGold,
    background = IslamicCream
)

@Composable
fun ZahraSpaceTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
