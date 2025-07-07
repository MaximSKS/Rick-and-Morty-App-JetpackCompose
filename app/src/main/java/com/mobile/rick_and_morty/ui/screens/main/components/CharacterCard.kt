package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.ui.designsystem.colors.gradientColorsFantasyLight
import com.mobile.rick_and_morty.ui.designsystem.grid.RickMortyShapes
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.preview.mock.CharacterMock

@Composable
fun CharacterCard(
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
        Box {
            Column(
                modifier = Modifier.padding(bottom = Spaces.space8),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(Spaces.space12)
            ) {

                GradientColorSection()
                NameText(text = character.name)
                StatusTextWithIndicator(
                    modifier = Modifier.padding(bottom = Spaces.space8),
                    text = "Status: ${character.status.name}",
                    statusColor = statusColor,
                )

            }
            //Avatar with status border
            AvatarWithStatusBorder(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .absoluteOffset(y = Sizes.size30)
                    .zIndex(1f),
                imageUrl = character.imageUrl,
                borderColor = statusColor,
            )

        }

    }
}

@Composable
private fun GradientColorSection(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = Spaces.space60)
            .height(Sizes.size100)  //Gradient height
            .background(
                Brush.linearGradient(
                    colors = gradientColorsFantasyLight
                )
            ),
        contentAlignment = Alignment.Center
    ) {}
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
        // Status indicator
        Box(
            modifier = modifier
                .size(Sizes.size6)
                .background(color = statusColor, shape = CircleShape)
        )
    }
}

@Preview
@Composable
fun CharacterCardPreview(modifier: Modifier = Modifier) {
    CharacterCard(
        character = CharacterMock.characterMockData,
        onCardClick = {}
    )
}