package com.maximus.dungeonmaster

import com.badlogic.gdx.Screen
import com.maximus.dungeonmaster.screens.GameScreen
import ktx.app.KtxGame
import ktx.inject.Context

val context = Context()

class Main : KtxGame<Screen>() {

    override fun create() {
        context.register {
            bindSingleton(GameScreen())
        }
        addScreen(context.inject<GameScreen>())

        setScreen<GameScreen>()
    }

    override fun dispose() {
        context.dispose()
    }
}