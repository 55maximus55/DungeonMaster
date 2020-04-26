package com.maximus.dungeonmaster.screens

import com.maximus.dungeonmaster.BlankScreen
import ktx.vis.table

class GameScreen : BlankScreen() {

    override val view = table {
        setFillParent(true)
        label("Game")
    }

    override fun show() {}
    override fun hide() {}

    override fun render(delta: Float) {}

    override fun pause() {}
    override fun resume() {}

    override fun resize(width: Int, height: Int) {}

    override fun dispose() {}

}