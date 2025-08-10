package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 25.sp,
    maxLines: Int = 2,
    align: Alignment.Horizontal = Alignment.CenterHorizontally,
    textAlign: TextAlign? = TextAlign.Center,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(align)
            .padding(horizontal = Spaces.space20),

        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}