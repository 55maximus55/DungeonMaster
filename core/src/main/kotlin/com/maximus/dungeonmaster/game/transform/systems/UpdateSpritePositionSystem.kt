package com.maximus.dungeonmaster.game.transform.systems

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.maximus.dungeonmaster.game.graphic.components.AnimatedSpriteComponent
import com.maximus.dungeonmaster.game.transform.components.TransformComponent
import ktx.ashley.allOf

class UpdateSpritePositionSystem : EntitySystem() {

    val family = allOf(AnimatedSpriteComponent::class, TransformComponent::class).get()

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val spriteComponent = entity.getComponent(AnimatedSpriteComponent::class.java)
            val transformComponent = entity.getComponent(TransformComponent::class.java)

            spriteComponent.sprite.setCenter(transformComponent.position.x, transformComponent.position.y)
        }
    }

}