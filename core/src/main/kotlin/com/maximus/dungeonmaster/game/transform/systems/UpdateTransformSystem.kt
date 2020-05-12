package com.maximus.dungeonmaster.game.transform.systems

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.maximus.dungeonmaster.game.box2d.components.Box2dBodyComponent
import com.maximus.dungeonmaster.game.transform.components.TransformComponent
import ktx.ashley.allOf

class UpdateTransformSystem(val PPM: Float) : EntitySystem() {

    val family = allOf(TransformComponent::class, Box2dBodyComponent::class).get()

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val transformComponent = entity.getComponent(TransformComponent::class.java)
            val bodyComponent = entity.getComponent(Box2dBodyComponent::class.java)

            transformComponent.position.set(bodyComponent.body.position.cpy().scl(PPM))
        }
    }

}