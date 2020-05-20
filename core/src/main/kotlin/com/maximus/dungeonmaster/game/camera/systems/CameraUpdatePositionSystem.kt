package com.maximus.dungeonmaster.game.camera.systems

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.graphics.OrthographicCamera
import com.maximus.dungeonmaster.game.camera.components.CameraTargetComponent
import com.maximus.dungeonmaster.game.transform.components.TransformComponent
import ktx.ashley.allOf
import ktx.graphics.moveTo

class CameraUpdatePositionSystem(val camera: OrthographicCamera) : EntitySystem() {

    val family = allOf(CameraTargetComponent::class, TransformComponent::class).get()

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val transformComponent = entity.getComponent(TransformComponent::class.java)

            camera.moveTo(transformComponent.position)
            camera.update()
        }
    }

}