package com.maximus.dungeonmaster.screens

import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.maximus.dungeonmaster.BlankScreen
import ktx.vis.table

class GameScreen : BlankScreen() {

    override val view = table {
        top()
        left()
        setFillParent(true)

        label("Game Screen")
    }

    val map: TiledMap = TmxMapLoader().load("maps/map1.tmx")

    override fun show() {}
    override fun hide() {}

    override fun render(delta: Float) {}

    override fun pause() {}
    override fun resume() {}

    override fun resize(width: Int, height: Int) {}

    override fun dispose() {}

}