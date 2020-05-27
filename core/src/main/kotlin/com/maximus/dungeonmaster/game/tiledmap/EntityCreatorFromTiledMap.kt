package com.maximus.dungeonmaster.game.tiledmap

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import com.maximus.dungeonmaster.game.entities.PlayerEntity
import com.maximus.dungeonmaster.game.entities.TriggerEntity
import ktx.tiled.*

class EntityCreatorFromTiledMap {

    companion object {
        fun createEntities(engine: Engine, world: World, map: TiledMap) {
            map.forEachMapObject("entities") { mapObj ->
                val pos = Vector2(mapObj.x / map.tileWidth, mapObj.y / map.tileHeight)
                when (mapObj.name) {
                    "player" -> PlayerEntity.create(engine, world, pos)
                    "trigger" -> TriggerEntity.create(engine, world, pos, mapObj.shape, map.tileWidth.toFloat(), mapObj.type.toString())
                }
            }
        }
    }

}