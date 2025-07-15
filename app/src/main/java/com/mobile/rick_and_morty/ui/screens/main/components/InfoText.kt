package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces

@Composable
fun InfoText(
    modifier: Modifier = Modifier,
    headingText: String,
    infoText: String,
    infoTextFontSize: TextUnit = 16.sp,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(space = Spaces.space6),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = modifier,
            text = headingText,
            fontSize = 14.sp,
            color = Color.Gray,
        )

        Text(
            text = infoText,
            fontWeight = FontWeight.SemiBold,
            fontSize = infoTextFontSize,
            maxLines = maxLines,
            overflow = overflow,
        )

    }

}