package com.mobile.rick_and_morty.ui.navigation.typesafenavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

/* NavGraph for Rick and Morty app */
@Composable
fun RickMortyNavGraph(
   // modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        //modifier = modifier,
        navController = navController,
        startDestination = CharacterGraph
    ) {

        characterGraph(navController)
        locationGraph(navController)
        episodeGraph(navController)

    }
}