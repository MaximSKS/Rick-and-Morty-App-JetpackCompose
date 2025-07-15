package com.mobile.rick_and_morty.ui.screens.main.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.ui.designsystem.colors.gradientColorsFantasyLight
import com.mobile.rick_and_morty.ui.designsystem.colors.primaryWhite
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.navigation.typesafenavigation.CharacterGraph
import com.mobile.rick_and_morty.ui.navigation.typesafenavigation.EpisodeGraph
import com.mobile.rick_and_morty.ui.navigation.typesafenavigation.LocationGraph

@Composable
fun BottomNavBar(modifier: Modifier = Modifier , navController: NavHostController) {

    val bottomNavDestinations = listOf(CharacterGraph, LocationGraph, EpisodeGraph)

    Box(
        modifier = Modifier.padding(top = Spaces.space2)
            .navigationBarsPadding()
            .background(brush = Brush.linearGradient(colors = gradientColorsFantasyLight)),
        contentAlignment = Alignment.Center
    ) {
        BottomNavigation(
            modifier = Modifier.background(color = Color.Black),

            ) {
            val entry by navController.currentBackStackEntryAsState()
            val currentDestination = entry?.destination

            bottomNavDestinations.forEach { destination ->
                BottomNavigationItem(
                    modifier = Modifier.padding(all = Spaces.space4),
                    selected = currentDestination?.hierarchy?.any {
                        it.hasRoute(destination::class)
                    } == true,

                    onClick = {
                        navController.navigate(destination)
                    },

                    icon = {
                        Icon(
                            modifier = Modifier.padding(all = Spaces.space6),
                            imageVector =
                                when (destination) {
                                    CharacterGraph -> Icons.Default.Face
                                    LocationGraph -> Icons.Default.LocationOn
                                    EpisodeGraph -> Icons.Default.Menu
                                    else -> Icons.Filled.Notifications
                                },
                            contentDescription = "",
                        )
                    },

                    label = {
                        Text(
                            text =
                                when (destination) {
                                    CharacterGraph -> stringResource(R.string.top_btm_bar_characters_txt)
                                    LocationGraph -> stringResource(R.string.top_btm_bar_locations_txt)
                                    EpisodeGraph -> stringResource(R.string.top_btm_bar_episodes_txt)
                                    else -> ""
                                },

                            color = primaryWhite,

                            )
                    },
                )
            }

        }
    }

}