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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.mobile.rick_and_morty.R
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {

            GradientColorSection(modifier = Modifier.align(Alignment.CenterStart))

            Row(
                modifier = Modifier
                    .matchParentSize()
                    .padding(start = Sizes.size70 + Spaces.space30, end = Spaces.space30)
                    .zIndex(0f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .height(IntrinsicSize.Min),
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = Spaces.space30),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(space = Spaces.space8)
                    ) {

                        NameText(
                            modifier = Modifier.fillMaxWidth(),
                            text = character.name,
                            maxLines = 2,
                            textAlign = TextAlign.Center
                        )

                        StatusTextWithIndicator(
                            modifier = Modifier.padding(bottom = Spaces.space8),
                            text = stringResource(R.string.status_txt, character.status.name),   // "Status: ${character.status.name}"
                            statusColor = statusColor,
                        )
                    }
                }


            }

            AvatarWithStatusBorder(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .absoluteOffset(x = Sizes.size30)
                    .padding(vertical = Spaces.space10)
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


@Preview
@Composable
fun CharacterCardHorizontalPreview() {
    CharacterCardHorizontal(
        character = CharacterMock.characterMockData,
        onCardClick = {}
    )
}