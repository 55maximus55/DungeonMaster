package com.maximus.dungeonmaster

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.I18NBundle
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.kotcrab.vis.ui.VisUI
import com.maximus.dungeonmaster.screens.GameScreen
import com.maximus.dungeonmaster.screens.MainMenuScreen
import ktx.app.KtxGame
import ktx.inject.Context
import ktx.scene2d.Scene2DSkin

val context = Context()

class Main : KtxGame<BlankScreen>() {

    companion object {

        lateinit var instance: Main

        inline fun  <reified Type : BlankScreen> setScreen() {
            instance.setScreen(Type::class.java)
        }

    }

    init {
        instance = this
    }

    override fun create() {
        context.register {
            VisUI.load()
            Scene2DSkin.defaultSkin = VisUI.getSkin()

            bindSingleton(I18NBundle.createBundle(Gdx.files.internal("i18n/lines")))

            bindSingleton(Stage(ScreenViewport()))

            bindSingleton(MainMenuScreen())
            bindSingleton(GameScreen())
        }
        addScreen(context.inject<MainMenuScreen>())
        addScreen(context.inject<GameScreen>())

        setScreen<MainMenuScreen>()

        val stage: Stage = context.inject()
        Gdx.input.inputProcessor = stage
    }

    override fun render() {
        super.render()
        val stage: Stage = context.inject()
        stage.apply {
            act(Gdx.graphics.deltaTime)
            draw()
        }
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        val stage: Stage = context.inject()
        stage.viewport.update(width, height, true)
    }

    override fun <Type : BlankScreen> setScreen(type: Class<Type>) {
        val stage: Stage = context.inject()
        stage.clear()
        super.setScreen(type)
        stage.addActor((currentScreen as BlankScreen).view)
    }

    override fun dispose() {
        context.dispose()
        VisUI.dispose()
    }

}