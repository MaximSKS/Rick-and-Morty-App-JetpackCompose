package com.mobile.rick_and_morty.ui.navigation.typesafenavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

/* NavGraph для type-safe навигации (в этом приложении используем type-safe) */
@Composable
fun RickMortyNavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CharacterGraph
    ) {

        characterGraph(navController)
        locationGraph(navController)
        episodeGraph(navController)

    }
}