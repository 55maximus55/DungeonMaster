package com.maximus.dungeonmaster

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.utils.I18NBundle
import com.maximus.dungeonmaster.screens.GameScreen
import ktx.app.KtxGame
import ktx.inject.Context

val context = Context()

class Main : KtxGame<Screen>() {

    override fun create() {
        context.register {
            bindSingleton(I18NBundle.createBundle(Gdx.files.internal("i18n/lines")))

            bindSingleton(GameScreen())
        }
        addScreen(context.inject<GameScreen>())

        setScreen<GameScreen>()
    }

    override fun dispose() {
        context.dispose()
    }
}