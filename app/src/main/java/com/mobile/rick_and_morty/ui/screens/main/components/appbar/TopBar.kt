package com.mobile.rick_and_morty.ui.screens.main.components.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.White, //contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation

    ) {
    TopAppBar(
        title = { Text(text = title, color = contentColor) },
        modifier = modifier,
        backgroundColor = backgroundColor,
        navigationIcon = navigationIcon,
        actions = actions,
        contentColor = contentColor,
        elevation = elevation
    )
}