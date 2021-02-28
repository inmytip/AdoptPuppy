package com.inmytip.adoptpuppy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Brown600,
    primaryVariant = PurpleA100_dark,
    secondary = PurpleA100_dark
)

private val LightColorPalette = lightColors(
    primary = PurpleA100,
    primaryVariant = PurpleA100_dark,
    onPrimary = White,
    secondary = Brown600,
    secondaryVariant = Brown600_dark,
    onSecondary = Black,
    background = GreenA100,

    /* Other default colors to override
    surface = Color.White,
    onBackground = PinK100,
    onSurface = Color.Black,
    */
)

@Composable
fun AdoptPuppyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}