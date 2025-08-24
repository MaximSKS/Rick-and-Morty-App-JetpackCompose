package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.mobile.rick_and_morty.ui.designsystem.grid.RickMortyShapes
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces

@Composable
fun <T> GenericCard(
    modifier: Modifier = Modifier,
    item: T, // specify type of from domain (Location, Episode e.t.c.)
    title: (T) -> String, // main text of a card
    trailing: (T) -> String = { "" }, // trailing text of card (shown on the right of a card)
    subtitle: (T) -> String = { "" }, // subtitle text of card (shown below title)
    onClick: (T) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RickMortyShapes.small,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = Sizes.size4),
        onClick = { onClick(item) }
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = Spaces.space8, horizontal = Spaces.space10),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Spaces.space6)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title(item),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = trailing(item))
            }

            Text(text = subtitle(item))
        }
    }
}