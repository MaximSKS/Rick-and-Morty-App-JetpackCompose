package com.mobile.rick_and_morty.ui.screens.main.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mobile.rick_and_morty.domain.model.CharacterStatus
import com.mobile.rick_and_morty.ui.designsystem.colors.darkNeonGray
import com.mobile.rick_and_morty.ui.designsystem.colors.limeNeon
import com.mobile.rick_and_morty.ui.designsystem.colors.redNeon

@Composable
fun CharacterStatusColor(status: CharacterStatus): Color {
    return when (status) {
        CharacterStatus.Alive -> limeNeon
        CharacterStatus.Dead -> redNeon
        CharacterStatus.Unknown -> darkNeonGray
    }
}