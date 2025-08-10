package com.mobile.rick_and_morty.ui.navigation.typesafenavigation

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.mobile.rick_and_morty.ui.screens.characters.CharacterDetailsScreen
import com.mobile.rick_and_morty.ui.screens.characters.CharactersMainScreen
import com.mobile.rick_and_morty.ui.screens.episodes.EpisodeDetailsScreen
import com.mobile.rick_and_morty.ui.screens.episodes.EpisodesScreen
import com.mobile.rick_and_morty.ui.screens.locations.LocationDetailsScreen
import com.mobile.rick_and_morty.ui.screens.locations.LocationsScreen
import com.mobile.rick_and_morty.ui.viewmodel.CharacterDetailsViewModel
import com.mobile.rick_and_morty.ui.viewmodel.CharactersMainViewModel
import com.mobile.rick_and_morty.ui.viewmodel.EpisodeDetailsViewModel
import com.mobile.rick_and_morty.ui.viewmodel.EpisodesViewModel
import com.mobile.rick_and_morty.ui.viewmodel.LocationDetailsViewModel
import com.mobile.rick_and_morty.ui.viewmodel.LocationsViewModel
import kotlinx.serialization.Serializable

@Serializable
data object CharacterGraph

fun NavGraphBuilder.characterGraph(navController: NavHostController) {
    navigation<CharacterGraph>(startDestination = CharactersMain) {

        composable<CharactersMain> {

            CharactersMainScreen(
                modifier = Modifier,
                viewModel = hiltViewModel<CharactersMainViewModel>(),
                navigateToCharacterDetailsScreen = { id ->
                    navController.navigate(CharacterDetails(id))
                },
                navController = navController
            )
        }

        composable<CharacterDetails> { backStackEntry ->
            val scrDetails: CharacterDetails = backStackEntry.toRoute()

            CharacterDetailsScreen(
                characterId = scrDetails.id,
                viewModel = hiltViewModel<CharacterDetailsViewModel>(),
                navigateToCharactersMainScreen = { navController.navigateUp() },
                navigateToEpisodeDetailsScreen = { id ->
                    navController.navigate(EpisodeDetails(id))
                }
            )
        }
    }
}


@Serializable
data object LocationGraph

fun NavGraphBuilder.locationGraph(navController: NavHostController) {
    navigation<LocationGraph>(startDestination = Locations) {
        composable<Locations> {
            LocationsScreen(
                viewModel = hiltViewModel<LocationsViewModel>(),
                navigateToLocationDetailsScreen = { id -> navController.navigate(LocationDetails(id)) },
                navController = navController
            )
        }

        composable<LocationDetails> { backStackEntry ->
            val scrDetails: LocationDetails = backStackEntry.toRoute()

            LocationDetailsScreen(
                locationId = scrDetails.id,
                viewModel = hiltViewModel<LocationDetailsViewModel>(),
                navigateToLocationsScreen = { navController.navigateUp() },
                navigateToCharacterDetailsScreen = { id ->
                    navController.navigate(CharacterDetails(id))
                }

            )
        }
    }
}


@Serializable
data object EpisodeGraph

fun NavGraphBuilder.episodeGraph(navController: NavHostController) {

    navigation<EpisodeGraph>(startDestination = Episodes) {
        composable<Episodes> {
            EpisodesScreen(
                modifier = Modifier,
                viewModel = hiltViewModel<EpisodesViewModel>(),
                navigateToEpisodeDetailsScreen = { id ->
                    navController.navigate(EpisodeDetails(id))
                },
                navController = navController
            )
        }

        composable<EpisodeDetails> { backStackEntry ->
            val scrDetails: EpisodeDetails = backStackEntry.toRoute()

            EpisodeDetailsScreen(
                episodeId = scrDetails.id,
                viewModel = hiltViewModel<EpisodeDetailsViewModel>(),
                navigateToEpisodesScreen = { navController.navigateUp() },
                navigateToCharacterDetailsScreen = { id ->
                    navController.navigate(CharacterDetails(id))
                }

            )
        }

    }
}