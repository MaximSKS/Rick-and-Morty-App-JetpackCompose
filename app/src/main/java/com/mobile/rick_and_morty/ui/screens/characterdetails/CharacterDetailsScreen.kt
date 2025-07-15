package com.mobile.rick_and_morty.ui.screens.characterdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.ui.designsystem.colors.gradientColorsFantasyLight
import com.mobile.rick_and_morty.ui.designsystem.grid.RickMortyShapes
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.screens.main.UiState
import com.mobile.rick_and_morty.ui.screens.main.components.AvatarWithStatusBorder
import com.mobile.rick_and_morty.ui.screens.main.components.CharacterStatusColor
import com.mobile.rick_and_morty.ui.screens.main.components.EpisodeCard
import com.mobile.rick_and_morty.ui.screens.main.components.HeaderText
import com.mobile.rick_and_morty.ui.screens.main.components.InfoText
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.TopBar
import com.mobile.rick_and_morty.ui.viewmodel.CharacterDetailsViewModel

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    viewModel: CharacterDetailsViewModel,
    navigateToCharactersMainScreen: () -> Unit,
) {
    val characterState by viewModel.characterState.collectAsState()
    val episodesState by viewModel.episodesState.collectAsState()


    LaunchedEffect(characterId) {
        viewModel.loadCharacter(characterId)
    }

    when (characterState) {

        is UiState.Loading -> {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is UiState.Error -> {
            val message = (characterState as UiState.Error).message
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = message, color = Color.Red)
            }
        }

        is UiState.Success -> {

            val character = (characterState as UiState.Success).data
            val statusColor = CharacterStatusColor(character.status)


            LaunchedEffect(character) {
                viewModel.loadEpisodes(character.episodeUrls)
            }

            Scaffold(

                topBar = {

                    TopBar(
                        // modifier = Modifier.fillMaxWidth().statusBarsPadding(),
                        title = character.name,
                        navigationIcon =
                            {
                                IconButton(
                                    onClick = { navigateToCharactersMainScreen() },
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
                        CharacterHeaderSection(
                            character = character,
                            statusColor = statusColor
                        )
                    }

                    item {
                        CharacterInfoSection(
                            character = character,
                            statusColor = statusColor
                        )
                    }

                    item {
                        HeaderText(
                            modifier = Modifier.padding(
                                start = Spaces.space20,
                                top = Spaces.space20,
                                bottom = Spaces.space20
                            ),
                            fontSize = 18.sp,
                            text = stringResource(R.string.episodes_txt)
                        )
                    }


                    when (episodesState) {
                        is UiState.Loading -> {

                            item {
                                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                                    CircularProgressIndicator(Modifier.padding(Spaces.space16))
                                }
                            }
                        }

                        is UiState.Error -> {

                            val errorMsg = (episodesState as UiState.Error).message
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

                            val episodes = (episodesState as UiState.Success).data

                            items(items = episodes, key = { it.id }) { episode ->
                                EpisodeCard(
                                    modifier = Modifier
                                        .padding(horizontal = Spaces.space16, vertical = Spaces.space5),
                                    episodeId = episode.id,
                                    episodeName = episode.name,
                                    airDate = episode.airDate,
                                    episodeCode = episode.episodeCode
                                ) { /* episode onClick */ }
                            }

                        }
                    }
                }
            }
        }
    }
}


//@Composable
// fun HeaderText(
//    modifier: Modifier = Modifier,
//    text: String,
//    fontSize: TextUnit = 25.sp,
//    maxLines: Int = 1,
//    overflow: TextOverflow = TextOverflow.Ellipsis
//) {
//    Text(
//        modifier = modifier,
//        text = text,
//        fontWeight = FontWeight.Bold,
//        fontSize = fontSize,
//        maxLines = maxLines,
//        overflow = overflow,
//    )
//}

@Composable
private fun CharacterHeaderSection(
    modifier: Modifier = Modifier,
    character: Character,
    statusColor: Color
) {
    Box {
        Column(
            modifier = modifier.padding(bottom = Spaces.space8),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Spaces.space12)
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = Spaces.space130)
                    .height(Sizes.size180)
                    .background(
                        Brush.linearGradient(
                            colors = gradientColorsFantasyLight
//                                listOf(
//                                Color(0xFF7F7FD5),
//                                Color(0xFF86A8E7),
//                                Color(0xFF91EAE4)
//                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {}

            HeaderText(text = character.name)

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = Sizes.size1,
                color = Color.LightGray
            )
        }

        AvatarWithStatusBorder(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .absoluteOffset(y = 50.dp)
                .zIndex(1f),
            imageUrl = character.imageUrl ?: "",
            imageSize = Sizes.size250,
            borderColor = statusColor
        )
    }
}


//@Composable
//private fun InfoText(
//    modifier: Modifier = Modifier,
//    headingText: String,
//    infoText: String,
//    infoTextFontSize: TextUnit = 16.sp,
//    maxLines: Int = 1,
//    overflow: TextOverflow = TextOverflow.Ellipsis
//) {
//
//    Column(
//        verticalArrangement = Arrangement.spacedBy(space = Spaces.space6),
//        horizontalAlignment = Alignment.Start,
//    ) {
//        Text(
//            modifier = modifier,
//            text = headingText,
//            fontSize = 14.sp,
//            color = Color.Gray,
//        )
//
//        Text(
//            text = infoText,
//            fontWeight = FontWeight.SemiBold,
//            fontSize = infoTextFontSize,
//            maxLines = maxLines,
//            overflow = overflow,
//        )
//
//    }
//
//}


@Composable
private fun InfoTextWithStatusIndicator(
    modifier: Modifier = Modifier,
    headingText: String,
    infoText: String,
    statusColor: Color,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(space = Spaces.space6),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = modifier,
            text = headingText,
            fontSize = 14.sp,
            color = Color.Gray,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = Spaces.space6),
        ) {
            Text(
                text = infoText,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
            )

            Box(
                modifier = modifier
                    .size(Sizes.size6)
                    .background(color = statusColor, shape = CircleShape)
            )
        }

    }

}

@Composable
private fun CharacterInfoSection(
    modifier: Modifier = Modifier,
    character: Character,
    statusColor: Color
) {
    val infoList = listOf(
        stringResource(R.string.species_and_gender_txt) to "${character.species} (${character.gender.name})",
        stringResource(R.string.last_known_location_txt) to character.locationName,
        stringResource(R.string.first_seen_in_txt) to character.name
    )

    Column(
        modifier = modifier
            .padding(horizontal = Spaces.space20, vertical = Spaces.space10),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Spaces.space14)
    ) {
        InfoTextWithStatusIndicator(
            headingText = stringResource(R.string.live_status_txt),
            infoText = character.status.name,
            statusColor = statusColor
        )

        infoList.forEach { (heading, info) ->
            InfoText(headingText = heading, infoText = info)
        }
    }
}


//@Composable
// fun EpisodeCard(
//    modifier: Modifier = Modifier,
//    episodeId: Int,
//    episodeName: String,
//    airDate: String,
//    episodeCode: String,
//    onCardClick: (episodeId: Int) -> Unit
//) {
//    Card(
//        modifier = modifier,
//        shape = RickMortyShapes.small,
//        // colors = CardDefaults.cardColors(Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = Sizes.size4),
//        onClick = { onCardClick(episodeId) }
//    ) {
//        Column(
//            modifier = Modifier.padding(vertical = Spaces.space8, horizontal = Spaces.space10),
//            horizontalAlignment = Alignment.Start,
//            verticalArrangement = Arrangement.spacedBy(Spaces.space6),
//        ) {
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
//            ) {
//                Text(
//                    modifier = Modifier.weight(1f),
//                    text = episodeName,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Text(text = episodeCode)
//
//            }
//
//            Text(text = airDate)
//        }
//    }
//}