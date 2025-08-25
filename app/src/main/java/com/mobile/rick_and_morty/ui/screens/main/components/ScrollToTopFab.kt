package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun ScrollToTopFab(
    firstVisibleItemIndexProvider: () -> Int,
    animateScrollToItem: suspend (Int) -> Unit,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    // Show FAB if first visible item is not first item
    val showScrollToTopButton by remember {
        derivedStateOf { firstVisibleItemIndexProvider() > 1 }
    }

    AnimatedVisibility(visible = showScrollToTopButton) {
        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    animateScrollToItem(0)
                }
            }, shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Up",
                tint = Color.White
            )
        }
    }
}
