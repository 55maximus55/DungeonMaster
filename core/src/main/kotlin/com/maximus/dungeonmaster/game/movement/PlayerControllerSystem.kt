package com.maximus.dungeonmaster.game.movement

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import ktx.ashley.allOf

class PlayerControllerSystem : EntitySystem() {

    val family = allOf(MovementComponent::class, PlayerControllerComponent::class).get()
    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val movementComponent = entity.getComponent(MovementComponent::class.java)

            movementComponent.control.apply {
                set(0f, 0f)
                if (Gdx.input.isKeyPressed(Input.Keys.W)) add(0f, 1f)
                if (Gdx.input.isKeyPressed(Input.Keys.A)) add(-1f, 0f)
                if (Gdx.input.isKeyPressed(Input.Keys.S)) add(0f, -1f)
                if (Gdx.input.isKeyPressed(Input.Keys.D)) add(1f, 0f)
                clamp(0f, 1f)
            }
        }
    }

}