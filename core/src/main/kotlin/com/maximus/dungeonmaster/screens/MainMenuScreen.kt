package com.maximus.dungeonmaster.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.maximus.dungeonmaster.BlankScreen
import com.maximus.dungeonmaster.Main
import ktx.actors.onChange
import ktx.vis.table

class MainMenuScreen : BlankScreen() {

    override val view = table {
        setFillParent(true)
        textButton("New Game").apply {
            onChange {
                Main.setScreen<GameScreen>()
            }
        }
    }

    override fun show() {}
    override fun hide() {}

    override fun render(delta: Float) {}

    override fun pause() {}
    override fun resume() {}

    override fun resize(width: Int, height: Int) {}

    override fun dispose() {}

}