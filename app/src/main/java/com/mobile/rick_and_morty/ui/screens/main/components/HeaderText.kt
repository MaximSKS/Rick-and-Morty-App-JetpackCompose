package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
 fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 25.sp,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        maxLines = maxLines,
        overflow = overflow,
    )
}