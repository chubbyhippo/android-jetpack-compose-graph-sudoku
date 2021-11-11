package com.example.graphsudoku.ui.newgame.buildlogic

import android.content.Context
import com.example.graphsudoku.common.ProductionDispatcherProvider
import com.example.graphsudoku.persistence.*
import com.example.graphsudoku.ui.newgame.NewGameContainer
import com.example.graphsudoku.ui.newgame.NewGameLogic
import com.example.graphsudoku.ui.newgame.NewGameViewModel

internal fun buildNewGameLogic(
    container: NewGameContainer,
    viewModel: NewGameViewModel,
    context: Context
): NewGameLogic {
    return NewGameLogic(
        container,
        viewModel,
        GameRepositoryImpl(
            LocalGameStorageImpl(context.filesDir.path),
            LocalSettingsStorageImpl(context.settingsDataStore)
        ),
        LocalStatisticsStorageImpl(
            context.statsDataStore
        ),
        ProductionDispatcherProvider
    )
}