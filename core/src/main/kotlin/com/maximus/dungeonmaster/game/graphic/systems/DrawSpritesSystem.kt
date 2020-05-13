package com.maximus.dungeonmaster.game.graphic.systems

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Batch
import com.maximus.dungeonmaster.context
import com.maximus.dungeonmaster.game.graphic.components.AnimatedSpriteComponent
import ktx.ashley.allOf
import ktx.graphics.use

class DrawSpritesSystem(val camera: OrthographicCamera) : EntitySystem() {

    val family = allOf(AnimatedSpriteComponent::class).get()
    lateinit var entities: ImmutableArray<Entity>

    val batch: Batch = context.inject()

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        batch.use(camera) {
            for (entity in entities) {
                val spriteComponent = entity.getComponent(AnimatedSpriteComponent::class.java)
                spriteComponent.sprite.draw(batch)
            }
        }
    }

}