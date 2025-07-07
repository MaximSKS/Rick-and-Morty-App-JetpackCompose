package com.mobile.rick_and_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mobile.rick_and_morty.ui.designsystem.Jetpack_Paging_Rick_and_MortyTheme
import com.mobile.rick_and_morty.ui.navigation.typesafenavigation.RickMortyNavGraph
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.BottomNavBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Jetpack_Paging_Rick_and_MortyTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavBar(
                            modifier = Modifier.fillMaxWidth(),
                            navController = navController
                        )
                    }
                ) { innerPadding ->

                    RickMortyNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }

            }
        }
    }
}