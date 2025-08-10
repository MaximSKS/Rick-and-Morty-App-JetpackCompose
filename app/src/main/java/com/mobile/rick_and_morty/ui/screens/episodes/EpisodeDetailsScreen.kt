package com.mobile.rick_and_morty.ui.screens.episodes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.screens.main.UiState
import com.mobile.rick_and_morty.ui.screens.main.components.CharacterCardHorizontal
import com.mobile.rick_and_morty.ui.screens.main.components.HeaderText
import com.mobile.rick_and_morty.ui.screens.main.components.InfoText
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.TopBar
import com.mobile.rick_and_morty.ui.viewmodel.EpisodeDetailsViewModel

@Composable
fun EpisodeDetailsScreen(
    episodeId: Int,
    viewModel: EpisodeDetailsViewModel,
    navigateToEpisodesScreen: () -> Unit,
    navigateToCharacterDetailsScreen: (characterId: Int) -> Unit,
) {
    val episodeState by viewModel.episodeState.collectAsState()
    val charactersState by viewModel.charactersState.collectAsState()

    LaunchedEffect(episodeId) {
        viewModel.loadEpisode(episodeId)
    }

    when (episodeState) {

        is UiState.Loading -> {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is UiState.Error -> {
            val message = (episodeState as UiState.Error).message
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = message, color = Color.Red)
            }
        }

        is UiState.Success -> {

            val episode = (episodeState as UiState.Success).data

            LaunchedEffect(episode) {
                viewModel.loadCharacters(episode.characters)
            }

            Scaffold(

                topBar = {

                    TopBar(
                        // modifier = Modifier.fillMaxWidth().statusBarsPadding(),
                        title = "Episode details",
                        navigationIcon =
                            {
                                IconButton(
                                    onClick = { navigateToEpisodesScreen() },
                                    content = {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Arrow back icon",
                                        )
                                    }
                                )
                            },
                    )

                },

                ) { innerPadding ->

                LazyColumn(
                    modifier = Modifier.padding(innerPadding).fillMaxSize(),
                ) {

                    item {
                        EpisodeHeaderSection(episode = episode)
                    }

                    item{
                        EpisodeInfoSection(
                            episode = episode
                        )
                    }

                    item {
                        HeaderText(
                            modifier = Modifier
                                .padding(top = Spaces.space20, bottom = Spaces.space20),
                            align = Alignment.Start,
                            fontSize = 18.sp,
                            text = stringResource(R.string.characters_txt)
                        )
                    }


                    when (charactersState) {
                        is UiState.Loading -> {

                            item {
                                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                                    CircularProgressIndicator(Modifier.padding(Spaces.space16))
                                }
                            }
                        }

                        is UiState.Error -> {

                            val errorMsg = (charactersState as UiState.Error).message
                            item {
                                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                                    Text(
                                        text = errorMsg,
                                        color = Color.Red,
                                        modifier = Modifier.padding(Spaces.space16)
                                    )
                                }
                            }
                        }

                        is UiState.Success -> {

                            val characters = (charactersState as UiState.Success).data

                            items(items = characters, key = { it.id }) { character ->
                                CharacterCardHorizontal(
                                    modifier = Modifier
                                        .padding(horizontal = Spaces.space16, vertical = Spaces.space5),
                                    character = character,
                                    onCardClick = { navigateToCharacterDetailsScreen(character.id) }
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EpisodeHeaderSection(
    modifier: Modifier = Modifier,
    episode: Episode,
) {
        Column(
            modifier = modifier.padding(top = Spaces.space40),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Spaces.space12)
        ) {
            HeaderText(
                //modifier = modifier.padding(horizontal = Spaces.space20),
                text = episode.name,
                overflow = TextOverflow.Visible,
               // maxLines = 2
            )

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = Sizes.size1,
                color = Color.LightGray
            )
        }
}


@Composable
private fun EpisodeInfoSection(
    modifier: Modifier = Modifier,
    episode: Episode,

) {
    val infoList = listOf(
        stringResource(R.string.episode_air_date_txt) to episode.airDate,
        stringResource(R.string.episode_code_txt) to episode.episodeCode,
    )

    Column(
        modifier = modifier.padding(horizontal = Spaces.space20, vertical = Spaces.space10),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Spaces.space14)
    ) {

        infoList.forEach { (heading, info) ->
            InfoText(headingText = heading, infoText = info)
        }
    }
}