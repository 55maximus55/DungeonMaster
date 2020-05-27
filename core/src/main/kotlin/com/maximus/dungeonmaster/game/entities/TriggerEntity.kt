package com.maximus.dungeonmaster.game.entities

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Shape2D
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.World
import com.maximus.dungeonmaster.game.NameComponent
import com.maximus.dungeonmaster.game.box2d.Box2dBodyData
import com.maximus.dungeonmaster.game.box2d.components.Box2dBodyComponent
import com.maximus.dungeonmaster.game.quests.triggertargets.TriggerTargetName
import ktx.box2d.body

class TriggerEntity {

    companion object {
        fun create(engine: Engine, world: World, pos: Vector2, shape: Shape2D, PPM: Float, target: String) {
            val entity = Entity()
            engine.addEntity(entity)

            entity.add(Box2dBodyComponent(world.body {
                type = BodyDef.BodyType.StaticBody
                userData = Box2dBodyData(entity)

                position.set(pos)
                if (shape is Rectangle) {
                    box(width = shape.width / PPM, height = shape.height / PPM)
                    position.add(shape.width / PPM / 2, shape.height / PPM / 2)
                }
            }))
            entity.add(NameComponent("trigger"))
            entity.add(TriggerTargetName(target))
        }
    }

}