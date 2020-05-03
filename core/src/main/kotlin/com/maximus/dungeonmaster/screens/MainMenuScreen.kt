package com.maximus.dungeonmaster.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.I18NBundle
import com.maximus.dungeonmaster.BlankScreen
import com.maximus.dungeonmaster.Main
import com.maximus.dungeonmaster.context
import ktx.actors.onChange
import ktx.vis.table

class MainMenuScreen : BlankScreen() {

    val strings: I18NBundle = context.inject()

    override val view = table {
        setFillParent(true)
        textButton(strings["btn_NewGame"]).apply {
            onChange {
                Main.setScreen<GameScreen>()
            }
        }
        row()
        textButton(strings["btn_Exit"]).apply {
            onChange {
                Gdx.app.exit()
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