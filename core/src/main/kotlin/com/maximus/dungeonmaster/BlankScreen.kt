package com.maximus.dungeonmaster

import com.badlogic.ashley.core.PooledEngine
import ktx.app.KtxScreen
import ktx.vis.table

open class BlankScreen : KtxScreen {

    open val view = table {}
    val engine = PooledEngine()

    override fun render(delta: Float) {
        engine.update(delta)
    }

}