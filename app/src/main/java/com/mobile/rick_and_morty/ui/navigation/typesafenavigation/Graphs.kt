package com.mobile.rick_and_morty.ui.navigation.typesafenavigation

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.mobile.rick_and_morty.ui.screens.characterdetails.CharacterDetailsScreen
import com.mobile.rick_and_morty.ui.screens.charactersmainscreen.CharactersMainScreen
import com.mobile.rick_and_morty.ui.screens.episodes.EpisodesScreen
import com.mobile.rick_and_morty.ui.screens.locations.LocationsScreen
import com.mobile.rick_and_morty.ui.viewmodel.CharacterDetailsViewModel
import com.mobile.rick_and_morty.ui.viewmodel.CharacterMainViewModel
import kotlinx.serialization.Serializable

@Serializable
data object CharacterGraph

fun NavGraphBuilder.characterGraph(navController: NavHostController) {
    navigation<CharacterGraph>(startDestination = CharactersMain) {

        composable<CharactersMain> {

            CharactersMainScreen(
                modifier = Modifier,
                viewModel = hiltViewModel<CharacterMainViewModel>(),
                navigateToCharacterDetailsScreen = { id ->
                    navController.navigate(CharacterDetails(id))
                }
            )
        }

        composable<CharacterDetails> { backStackEntry ->
            val scrDetails: CharacterDetails = backStackEntry.toRoute()

            CharacterDetailsScreen(
                characterId = scrDetails.id,
                viewModel = hiltViewModel<CharacterDetailsViewModel>(),
                navigateToCharactersMainScreen = { navController.navigateUp() }
            )
        }
    }
}


@Serializable
data object LocationGraph

fun NavGraphBuilder.locationGraph(navController: NavHostController) {
    navigation<LocationGraph>(startDestination = Locations) {
        composable<Locations> {
            LocationsScreen() // To do like composable<CharactersMain> {...}
        }

        //composable<LocationDetails> { // to do like composable<CharacterDetails> {...} }
    }
}


@Serializable
data object EpisodeGraph

fun NavGraphBuilder.episodeGraph(navController: NavHostController) {
    navigation<EpisodeGraph>(startDestination = Episodes) {
        composable<Episodes> {
            EpisodesScreen() // To do like composable<CharactersMain> {...}
        }

       // composable<EpisodeDetails> { // to do like composable<CharacterDetails> {...} }
    }
}