package com.maximus.dungeonmaster.box2d.systems

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World

class Box2dWorldDebugRenderSystem(val world: World, val camera: OrthographicCamera, val PPM: Float) : EntitySystem() {

    val worldDebugRenderer = Box2DDebugRenderer()

    override fun update(deltaTime: Float) {
        worldDebugRenderer.apply {
            camera.apply {
                zoom /= PPM
                position.x /= PPM
                position.y /= PPM
                update()
                render(world, camera.combined)
                zoom *= PPM
                position.x *= PPM
                position.y *= PPM
                update()
            }
        }
    }

}