package com.mobile.rick_and_morty.ui.screens.locations


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.domain.model.Location
import com.mobile.rick_and_morty.ui.designsystem.grid.RickMortyShapes
import com.mobile.rick_and_morty.ui.designsystem.grid.Sizes
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces
import com.mobile.rick_and_morty.ui.screens.main.components.ErrorRetry
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.BottomNavBar
import com.mobile.rick_and_morty.ui.screens.main.components.appbar.TopBar
import com.mobile.rick_and_morty.ui.viewmodel.LocationsViewModel
import kotlinx.coroutines.launch

@Composable
fun LocationsScreen(
    modifier: Modifier = Modifier,
    viewModel: LocationsViewModel,
    navigateToLocationDetailsScreen: (locationId: Int) -> Unit,
    navController: NavHostController
) {
    val lazyPagingItems = viewModel.locations.collectAsLazyPagingItems()
    val coroutineScope = rememberCoroutineScope()
    val listState =  rememberLazyListState()
    // Show FAB if first visible item is not first item
    val showScrollToTopButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 1 }
    }

    androidx.compose.material.Scaffold(
        //Modifier.fillMaxSize().systemBarsPadding(),
        topBar = { TopBar(title = stringResource(R.string.top_btm_bar_episodes_txt)) },
        //modifier = Modifier.fillMaxWidth().statusBarsPadding(),
        bottomBar = {
            BottomNavBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController
            )
        },
        floatingActionButton = {
            AnimatedVisibility(visible = showScrollToTopButton) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
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
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
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

                    LazyColumn(
                        state = listState,
                        contentPadding = PaddingValues(all = Spaces.space14),
                        verticalArrangement = Arrangement.spacedBy(Spaces.space14),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        items(lazyPagingItems.itemCount) { index ->
                            val episode = lazyPagingItems[index]
                            episode?.let { it ->
                                AnimatedVisibility(
                                    visible = true,
                                    enter = fadeIn(animationSpec = tween(300)) + slideInVertically(),
                                    exit = fadeOut()
                                ) {
                                    LocationCard(
                                        location = it,
                                        onCardClick = { navigateToLocationDetailsScreen(it) }
                                    )
                                }
                            }
                        }

                        lazyPagingItems.apply {
                            when (loadState.append) {
                                is LoadState.Loading -> item {
                                    CircularProgressIndicator(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                Spaces.space16
                                            )
                                    )
                                }

                                is LoadState.Error -> item {
                                    val e = loadState.append as LoadState.Error
                                    ErrorRetry(
                                        message = e.error.localizedMessage
                                            ?: stringResource(R.string.unknown),
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
fun LocationCard(
    modifier: Modifier = Modifier,
    location: Location,
    onCardClick: (locationId: Int) -> Unit
) {
    Card(
        modifier = modifier,
        shape = RickMortyShapes.small,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = Sizes.size4),
        onClick = { onCardClick(location.id) }
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = Spaces.space8,
                horizontal = Spaces.space10
            ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Spaces.space6),
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = location.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = location.dimension)

            }

            Text(text = location.type)
        }
    }
}