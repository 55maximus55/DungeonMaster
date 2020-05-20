package com.maximus.dungeonmaster.game.hp

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.maximus.dungeonmaster.context
import com.maximus.dungeonmaster.game.graphic.components.AnimatedSpriteComponent
import ktx.ashley.allOf
import ktx.graphics.use

class DrawHpBarSystem(val camera: OrthographicCamera) : EntitySystem() {

    val family = allOf(AnimatedSpriteComponent::class, HpComponent::class).get()
    lateinit var entities: ImmutableArray<Entity>

    val shapeRenderer: ShapeRenderer = context.inject()

    override fun addedToEngine(engine: Engine?) {
        entities = engine!!.getEntitiesFor(family)
    }

    override fun update(deltaTime: Float) {
        shapeRenderer.apply {
            projectionMatrix = camera.combined
            use(ShapeRenderer.ShapeType.Filled) {
                for (entity in entities) {
                    val spriteComponent = entity.getComponent(AnimatedSpriteComponent::class.java)
                    val hpComponent = entity.getComponent(HpComponent::class.java)

                    color = Color.RED
                    shapeRenderer.rect(spriteComponent.sprite.x, spriteComponent.sprite.y + spriteComponent.sprite.height, spriteComponent.sprite.width, 5f)
                    color = Color.GREEN
                    shapeRenderer.rect(spriteComponent.sprite.x, spriteComponent.sprite.y + spriteComponent.sprite.height,
                            spriteComponent.sprite.width * (hpComponent.hp.toFloat() / hpComponent.mapHp.toFloat()), 5f)
                }
            }
        }
    }

}