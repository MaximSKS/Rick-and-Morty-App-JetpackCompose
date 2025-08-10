package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces

@Composable
fun StatusTextWithIndicator(
    modifier: Modifier = Modifier.padding(horizontal = Spaces.space8),
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    statusColor: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = Spaces.space5),
    ) {
        Text(
            text = text,
            textAlign = textAlign,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = modifier
        )
        // Status indicator
        Box(
            modifier = modifier
                .size(Sizes.size6)
                .background(color = statusColor, shape = CircleShape)
        )
    }
}