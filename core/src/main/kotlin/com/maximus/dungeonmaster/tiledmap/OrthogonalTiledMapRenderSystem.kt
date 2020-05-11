package com.maximus.dungeonmaster.tiledmap

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.maximus.dungeonmaster.context

class OrthogonalTiledMapRenderSystem(val map: TiledMap, val camera: OrthographicCamera) : EntitySystem() {

    val mapRenderer = OrthogonalTiledMapRenderer(map, context.inject<Batch>())

    override fun update(deltaTime: Float) {
        mapRenderer.apply {
            setView(camera)
            render()
        }
    }

}