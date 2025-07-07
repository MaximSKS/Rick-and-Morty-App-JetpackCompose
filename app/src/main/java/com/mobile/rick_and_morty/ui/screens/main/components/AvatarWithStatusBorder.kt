package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes

@Composable
fun AvatarWithStatusBorder(
    modifier: Modifier = Modifier,
    imageUrl: String,
    borderColor: Color,
    imageSize: Dp = Sizes.size120,
    borderWidth: Dp = Sizes.size4,

    ) {

    val totalSize = imageSize + borderWidth * 2

    Box(
        modifier = modifier
            .size(totalSize)
            .clip(CircleShape)
            .background(Color.White)
            .border(width = borderWidth, color = borderColor, shape = CircleShape)
            .padding(borderWidth)
    ) {
        AsyncImage(  // Coil lib
            model = imageUrl,
            contentDescription = "Avatar",
            placeholder = painterResource(id = R.drawable.ic_rick_and_morty),
            error = painterResource(id = R.drawable.ic_broken_image_24),
            modifier = Modifier
                .padding(borderWidth)
                .size(imageSize)
                .clip(CircleShape)
        )
    }
}