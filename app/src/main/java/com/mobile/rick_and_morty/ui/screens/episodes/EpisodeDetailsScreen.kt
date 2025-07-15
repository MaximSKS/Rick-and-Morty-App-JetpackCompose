package com.mobile.rick_and_morty.ui.screens.episodes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.screens.main.components.InfoText
import com.mobile.rick_and_morty.ui.viewmodel.EpisodeDetailsViewModel

@Composable
fun EpisodeDetailsScreen(
    episodeId: Int,
    viewModel: EpisodeDetailsViewModel,
    navigateToEpisodesScreen: () -> Unit,
) {

}


@Composable
private fun EpisodeInfoSection(
    modifier: Modifier = Modifier,
    episode: Episode,

) {
    val infoList = listOf(
        stringResource(R.string.episode_air_date_txt) to episode.airDate,
        stringResource(R.string.episode_code_txt) to episode.episodeCode,
        stringResource(R.string.episode_created_txt) to episode.created,
        //stringResource(R.string.episode_characters_txt) to episode.characters, /* TODO: Add characters card (horizontal) */
    )

    Column(
        modifier = modifier
            .padding(horizontal = Spaces.space20, vertical = Spaces.space10),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Spaces.space14)
    ) {


        infoList.forEach { (heading, info) ->
            InfoText(headingText = heading, infoText = info)
        }
    }
}