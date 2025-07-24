package com.mobile.rick_and_morty.ui.screens.charactersmainscreen


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.*
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.screens.main.components.CharacterCard
import com.mobile.rick_and_morty.ui.screens.main.components.ErrorRetry
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.BottomNavBar
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.TopBar
import com.mobile.rick_and_morty.ui.viewmodel.CharactersMainViewModel
import kotlinx.coroutines.launch


@Composable
fun CharactersMainScreen(
    modifier: Modifier = Modifier,
    viewModel: CharactersMainViewModel,
    navigateToCharacterDetailsScreen: (characterId: Int) -> Unit,
    navController: NavHostController
) {
    val lazyPagingItems = viewModel.characters.collectAsLazyPagingItems()
    val gridState = rememberLazyGridState() // remember grid's state
    val coroutineScope = rememberCoroutineScope()

    // Show FAB if first visible item is not first item
    val showScrollToTopButton by remember {
        derivedStateOf { gridState.firstVisibleItemIndex > 1 }
    }

    Scaffold(
        //Modifier.fillMaxSize().systemBarsPadding(),
        topBar = { TopBar(title = stringResource(R.string.top_btm_bar_characters_txt)) },
        //modifier = Modifier.fillMaxWidth().statusBarsPadding(),
        bottomBar = { BottomNavBar(modifier = Modifier.fillMaxWidth(), navController = navController)
        },
        floatingActionButton = {
            AnimatedVisibility(visible = showScrollToTopButton) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            gridState.animateScrollToItem(0)
                        }
                    },
                    shape = CircleShape,
                    backgroundColor = Color.DarkGray
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Scroll to Top",
                        tint = Color.White
                    )
                }
        }

        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (lazyPagingItems.loadState.refresh) {
                is LoadState.Loading -> {

                    CircularProgressIndicator(modifier = Modifier.fillMaxSize().wrapContentSize())
                }
                is LoadState.Error -> {

                    val e = lazyPagingItems.loadState.refresh as LoadState.Error
                    ErrorRetry(
                        message = e.error.localizedMessage ?: stringResource(R.string.unknown),
                        onRetry = { lazyPagingItems.retry() }
                    )
                }
                else -> {

                    LazyVerticalGrid(
                        state = gridState,
                        columns = GridCells.Adaptive(Sizes.size140), // GridCells can be defined as: Fixed(), Adaptive(), FixedSize()
                        contentPadding = PaddingValues(all = Spaces.space14),
                        verticalArrangement = Arrangement.spacedBy(Spaces.space14),
                        horizontalArrangement = Arrangement.spacedBy(Spaces.space14)
                    ) {
                        items(lazyPagingItems.itemCount) { index ->
                            val character = lazyPagingItems[index]
                            character?.let {
                                AnimatedVisibility(
                                    visible = true,
                                    enter = fadeIn(animationSpec = tween(300)) + slideInVertically(),
                                    exit = fadeOut()
                                ) {
                                    CharacterCard(character = it, onCardClick = { navigateToCharacterDetailsScreen(it) } )
                                }

                            }
                        }

                        lazyPagingItems.apply {
                            when (loadState.append) {
                                is LoadState.Loading -> item {
                                    CircularProgressIndicator(modifier = Modifier.fillMaxWidth().padding(Spaces.space16))
                                }
                                is LoadState.Error -> item {
                                    val e = loadState.append as LoadState.Error
                                    ErrorRetry(
                                        message = e.error.localizedMessage ?: stringResource(R.string.unknown),
                                        onRetry = { retry() }
                                    )
                                }
                                else -> {}
                            }
                        }


                    }

                }
            }
        }
    }
}


//@Composable
//fun ErrorRetry(modifier: Modifier = Modifier, message: String, onRetry: () -> Unit) {
//    Column(
//        modifier = modifier.fillMaxSize().wrapContentSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = stringResource(R.string.error_loading, message))
//
//        Button( modifier = modifier.padding(top = Spaces.space8),
//            onClick = onRetry) {
//            Text(text = stringResource(R.string.retry))
//        }
//    }
//}