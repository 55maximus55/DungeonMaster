package com.maximus.dungeonmaster.game.graphic.systems

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.maximus.dungeonmaster.game.graphic.components.AnimatedSpriteComponent
import ktx.ashley.allOf

class UpdateAnimatedSpriteSystem : EntitySystem() {

    val family = allOf(AnimatedSpriteComponent::class).get()

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val spriteComponent = entity.getComponent(AnimatedSpriteComponent::class.java)

            spriteComponent.timer += deltaTime
            if (spriteComponent.timer >= spriteComponent.duration) spriteComponent.timer -= spriteComponent.duration
            spriteComponent.sprite.setRegion((spriteComponent.timer / (spriteComponent.duration / 3)).toInt() * spriteComponent.sprite.width.toInt(),
                    0,
                    spriteComponent.sprite.width.toInt(), spriteComponent.sprite.height.toInt())
            // TODO(55_maximus_55): white this todo
        }
    }

}