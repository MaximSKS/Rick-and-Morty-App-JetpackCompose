package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobile.rick_and_morty.domain.model.Episode

@Composable
fun EpisodeCard(
    modifier: Modifier = Modifier,
    episode: Episode,
    onCardClick: (episodeId: Int) -> Unit
) {
    GenericCard(
        modifier = modifier,
        item = episode,
        onClick = { onCardClick(episode.id) },
        title = {episode.name}, //or Episode::name without '{}'
        trailing = { episode.episodeCode },
        subtitle = { episode.airDate }
    )
}