package com.mobile.rick_and_morty.ui.screens.locations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mobile.rick_and_morty.ui.navigation.typesafenavigation.RickMortyNavGraph
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.BottomNavBar
import com.mobile.rick_and_morty.ui.viewmodel.EpisodesViewModel

//Test locations screen for bottom nav bar. Will be implemented later.
@Composable
fun LocationsScreen(
    modifier: Modifier = Modifier,
    //viewModel: LocationsViewModel,
    //navigateToLocationDetailsScreen: (locationId: Int) -> Unit,
    navController: NavHostController

    ) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController
            )
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.padding(innerPadding)){
            Text(
                text = "Locations screen",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}