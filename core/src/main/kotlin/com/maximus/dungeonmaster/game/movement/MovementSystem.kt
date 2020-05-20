package com.maximus.dungeonmaster.game.movement

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.maximus.dungeonmaster.game.box2d.components.Box2dBodyComponent
import ktx.ashley.allOf

class MovementSystem : EntitySystem() {

    val family = allOf(MovementComponent::class, Box2dBodyComponent::class).get()
    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val box2dBodyComponent = entity.getComponent(Box2dBodyComponent::class.java)
            val movementComponent = entity.getComponent(MovementComponent::class.java)
            val speedComponent = entity.getComponent(SpeedComponent::class.java)

            box2dBodyComponent.body.linearVelocity = movementComponent.control.cpy().scl(speedComponent.speed)
        }
    }

}