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
import androidx.paging.LoadState
import androidx.paging.compose.*
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.screens.main.components.CharacterCard
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.TopBar
import com.mobile.rick_and_morty.ui.viewmodel.CharacterMainViewModel
import kotlinx.coroutines.launch


@Composable
fun CharactersMainScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterMainViewModel,
    navigateToCharacterDetailsScreen: (characterId: Int) -> Unit,
) {
    val lazyPagingItems = viewModel.characters.collectAsLazyPagingItems()
    val gridState = rememberLazyGridState() //  запоминаем состояние грида
    val coroutineScope = rememberCoroutineScope()

    // Показываем FAB(Floating Action Button) только если не на первом элементе.
    val showScrollToTopButton by remember {
        derivedStateOf { gridState.firstVisibleItemIndex > 1 }
    }

    Scaffold(
        //Modifier.fillMaxSize().systemBarsPadding(),
        topBar = { TopBar(title = stringResource(R.string.top_btm_bar_characters_txt)) },
        //modifier = Modifier.fillMaxWidth().statusBarsPadding(),
        bottomBar = { /* Set bottom bar with navigation items (characters, locations, episodes) */},
        floatingActionButton = {
            AnimatedVisibility(visible = showScrollToTopButton) {
                FloatingActionButton( // кнопка прокрутки к началу списка
                    onClick = {
                        coroutineScope.launch {
                            gridState.animateScrollToItem(0) // прокрутка к началу
                        }
                    },
                    shape = CircleShape, // форма кнопки
                    backgroundColor = Color.DarkGray // цвет кнопки
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
                    // индикация загрузки при старте
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize().wrapContentSize())
                }
                is LoadState.Error -> {
                    // экран ошибки при первоначальной загрузке
                    val e = lazyPagingItems.loadState.refresh as LoadState.Error
                    ErrorRetry(
                        message = e.error.localizedMessage ?: stringResource(R.string.unknown),
                        onRetry = { lazyPagingItems.retry() }
                    )
                }
                else -> {
                    // сам список
                    LazyVerticalGrid(
                        state = gridState, // передаём состояние
                        columns = GridCells.Adaptive(Sizes.size140), // GridCells могут быть определенны как Fixed(), Adaptive(), FixedSize()
                        contentPadding = PaddingValues(all = Spaces.space14),
                        verticalArrangement = Arrangement.spacedBy(Spaces.space14),
                        horizontalArrangement = Arrangement.spacedBy(Spaces.space14)
                    ) {
                        items(lazyPagingItems.itemCount) { index ->
                            val character = lazyPagingItems[index]
                            character?.let {
                                AnimatedVisibility( // Animation when card is loading
                                    visible = true,
                                    enter = fadeIn(animationSpec = tween(300)) + slideInVertically(),
                                    exit = fadeOut()
                                ) {
                                    CharacterCard(character = it, onCardClick = { navigateToCharacterDetailsScreen(it) } )
                                }

                            }
                        }
                        // отобразить индикатор внизу или кнопку retry
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


@Composable
private fun ErrorRetry(modifier: Modifier = Modifier,message: String, onRetry: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize().wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.error_loading_characters, message))

        Button( modifier = modifier.padding(top = Spaces.space8),
            onClick = onRetry) {
            Text(text = stringResource(R.string.retry))
        }
    }
}