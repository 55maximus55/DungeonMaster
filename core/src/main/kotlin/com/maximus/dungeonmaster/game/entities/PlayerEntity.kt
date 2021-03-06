package com.maximus.dungeonmaster.game.entities

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.World
import com.maximus.dungeonmaster.game.NameComponent
import com.maximus.dungeonmaster.game.box2d.Box2dBodyData
import com.maximus.dungeonmaster.game.box2d.components.Box2dBodyComponent
import com.maximus.dungeonmaster.game.camera.components.CameraTargetComponent
import com.maximus.dungeonmaster.game.graphic.components.AnimatedSpriteComponent
import com.maximus.dungeonmaster.game.hp.HpComponent
import com.maximus.dungeonmaster.game.movement.MovementComponent
import com.maximus.dungeonmaster.game.movement.PlayerControllerComponent
import com.maximus.dungeonmaster.game.movement.SpeedComponent
import com.maximus.dungeonmaster.game.transform.components.TransformComponent
import ktx.box2d.body

class PlayerEntity {

    companion object {
        fun create(engine: Engine, world: World, pos: Vector2) {
            val entity = Entity()
            engine.addEntity(entity)

            entity.add(Box2dBodyComponent(world.body {
                type = BodyDef.BodyType.DynamicBody
                userData = Box2dBodyData(entity)

                position.set(pos)
                circle(radius = 0.99f / 2f)
            }))
            entity.add(TransformComponent())
            entity.add(CameraTargetComponent())
            entity.add(AnimatedSpriteComponent(Sprite(Texture("characters/player.png")), 0.6f, 48f, 48f))
            entity.add(HpComponent())
            entity.add(SpeedComponent(5f))
            entity.add(PlayerControllerComponent())
            entity.add(MovementComponent())
            entity.add(NameComponent("player"))
        }
    }

}