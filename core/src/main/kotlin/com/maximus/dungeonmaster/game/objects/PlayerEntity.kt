package com.maximus.dungeonmaster.game.objects

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.World
import com.maximus.dungeonmaster.game.box2d.Box2dBodyData
import com.maximus.dungeonmaster.game.box2d.components.Box2dBodyComponent
import com.maximus.dungeonmaster.game.camera.components.CameraTargetComponent
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
                box(width = 0.99f, height = 0.99f)
            }))
            entity.add(TransformComponent())
            entity.add(CameraTargetComponent())
        }
    }

}