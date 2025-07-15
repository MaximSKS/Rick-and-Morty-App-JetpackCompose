package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mobile.rick_and_morty.R
import com.mobile.rick_and_morty.ui.designsystem.grid.Spaces

@Composable
fun ErrorRetry(modifier: Modifier = Modifier, message: String, onRetry: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize().wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.error_loading, message))

        Button( modifier = modifier.padding(top = Spaces.space8),
            onClick = onRetry) {
            Text(text = stringResource(R.string.retry))
        }
    }
}