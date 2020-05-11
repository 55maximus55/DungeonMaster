package com.maximus.dungeonmaster.box2d

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.World
import com.maximus.dungeonmaster.box2d.components.Box2dBodyComponent
import ktx.box2d.body

class Box2dWallEntity {

    companion object {
        fun create(engine: Engine, world: World, size: Vector2, pos: Vector2) {
            val entity = Entity()
            engine.addEntity(entity)

            val body = world.body {
                type = BodyDef.BodyType.StaticBody
                userData = Box2dBodyData(entity)

                position.set(pos.x, pos.y)
                box(width = size.x, height = size.y)
            }
            entity.add(Box2dBodyComponent(body))
        }
    }

}