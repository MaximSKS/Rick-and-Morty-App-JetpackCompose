package com.mobile.rick_and_morty.ui.screens.locations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

//Test locations screen for bottom nav bar. Will be implemented later.
@Composable
fun LocationsScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()){
        Text(
            text = "Locations screen",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )
    }
}