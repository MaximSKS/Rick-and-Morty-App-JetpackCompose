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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mobile.rick_and_morty.R
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

                NameText(
                    modifier = Modifier.padding(horizontal = Spaces.space8),
                    text = character.name,
                    textAlign = TextAlign.Center
                )

                StatusTextWithIndicator(
                    modifier = Modifier.padding(bottom = Spaces.space8),
                    text = stringResource(R.string.status_txt, character.status.name),
                    statusColor = statusColor,
                )

            }

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


@Preview
@Composable
fun CharacterCardPreview() {
    CharacterCard(
        character = CharacterMock.characterMockData,
        onCardClick = {}
    )
}