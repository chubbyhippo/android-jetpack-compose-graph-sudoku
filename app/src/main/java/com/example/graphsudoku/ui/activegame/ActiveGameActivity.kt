package com.example.graphsudoku.ui.activegame

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.graphsudoku.R
import com.example.graphsudoku.common.makeToast
import com.example.graphsudoku.ui.GraphSudokuTheme
import com.example.graphsudoku.ui.newgame.NewGameActivity

class ActiveGameActivity : AppCompatActivity(), ActiveGameContainer {
    private lateinit var logic: ActiveGameLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ActiveGameViewModel()

        setContent {
            GraphSudokuTheme {
                ActiveGameScreen(
                    onEventHandler = logic::onEvent,
                    viewModel
                )
            }
        }

        logic = buildActiveGameLogic(this, viewModel, applicationContext)
    }

    override fun onStart() {
        super.onStart()
        logic.onEvent(ActiveGameEvent.OnStart)
    }

    override fun onStop() {
        super.onStop()
        logic.onEvent(ActiveGameEvent.OnStop)

        //guarantee that onRestart not called

        finish()
    }

    override fun onNewGameClick() {
        startActivity(
            Intent(
                this,
                NewGameActivity::class.java
            )
        )
    }

    override fun showError() = makeToast(getString(R.string.generic_error))
}
