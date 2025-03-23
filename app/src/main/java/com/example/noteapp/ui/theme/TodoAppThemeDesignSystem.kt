package com.example.noteapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

// colors
data class NoteAppColorScheme(
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val primary: Color,
    val onPrimary: Color,
)

// typography
data class NoteAppTypography(
    val titleLarge: TextStyle,
    val titleNormal: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyNormal: TextStyle,
    val bodySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelNormal: TextStyle,
    val labelSmall: TextStyle,
)

// shape
data class NoteAppShape(
    val container: Shape,
    val button: Shape,
)

// size
data class NoteAppSize(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val normal: Dp )

