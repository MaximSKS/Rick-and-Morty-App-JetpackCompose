package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun NameText(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign,
    )
}