package com.maximus.dungeonmaster

import com.badlogic.gdx.Screen
import com.maximus.dungeonmaster.screens.GameScreen
import ktx.app.KtxGame

class Main : KtxGame<Screen>() {

    override fun create() {
        addScreen(GameScreen())

        setScreen<GameScreen>()
    }

}