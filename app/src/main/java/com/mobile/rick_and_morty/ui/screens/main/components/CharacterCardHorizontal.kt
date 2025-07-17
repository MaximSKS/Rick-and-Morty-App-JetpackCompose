package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.ui.designsystem.colors.gradientColorsFantasyLight
import com.mobile.rick_and_morty.ui.designsystem.grid.RickMortyShapes
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.preview.mock.CharacterMock

@Composable
fun CharacterCardHorizontal(
    modifier: Modifier = Modifier,
    character: Character,
    onCardClick: (characterId: Int) -> Unit
) {

    val statusColor = CharacterStatusColor(status = character.status)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RickMortyShapes.medium,
        colors = CardDefaults.cardColors(Color.White),
        onClick = { onCardClick(character.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = Sizes.size4)
    ) {
            Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {

                GradientColorSection(modifier = Modifier.align(Alignment.CenterStart))

                Row(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(start = Sizes.size70 + Spaces.space8)
                        .zIndex(0f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(space = Spaces.space8)
                    ){

                        NameText(text = character.name)

                        StatusTextWithIndicator(
                            modifier = Modifier.padding(bottom = Spaces.space8),
                            text = "Status: ${character.status.name}",
                            statusColor = statusColor,
                        )
                    }

                }

                AvatarWithStatusBorder(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .absoluteOffset(x = Sizes.size30)
                        .padding(vertical = Spaces.space10,)
                        .zIndex(1f),
                    imageUrl = character.imageUrl,
                    borderColor = statusColor,
                    imageSize = Sizes.size70,
                )

            }

    }
}

@Composable
private fun GradientColorSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(Sizes.size120 / 2 + Spaces.space8)
            .background(Brush.linearGradient(colors = gradientColorsFantasyLight))
            .zIndex(0f)
    )
}

@Composable
private fun NameText(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier.padding(horizontal = Spaces.space8)
    )
}

@Composable
private fun StatusTextWithIndicator(
    modifier: Modifier = Modifier,
    text: String,
    statusColor: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = Spaces.space5),
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = modifier.padding(horizontal = Spaces.space8)
        )

        Box(
            modifier = modifier
                .size(Sizes.size6)
                .background(color = statusColor, shape = CircleShape)
        )
    }
}

@Preview
@Composable
fun CharacterCardHorizontalPreview(modifier: Modifier = Modifier) {
    CharacterCardHorizontal(
        character = CharacterMock.characterMockData,
        onCardClick = {}
    )
}