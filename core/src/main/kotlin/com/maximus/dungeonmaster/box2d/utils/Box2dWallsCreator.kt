package com.maximus.dungeonmaster.box2d.utils

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import com.maximus.dungeonmaster.box2d.Box2dWallEntity
import ktx.tiled.forEachMapObject
import ktx.tiled.shape
import ktx.tiled.tileHeight
import ktx.tiled.tileWidth

class Box2dWallsCreator {

    companion object {
        fun createWalls(engine: Engine, map: TiledMap, world: World) {
            map.forEachMapObject("walls") { mapObj ->
                val rect = mapObj.shape as Rectangle
                val size = Vector2(
                        rect.getWidth() / map.tileWidth,
                        rect.getHeight() / map.tileHeight
                )
                val pos = Vector2(
                        (rect.getX() + rect.getWidth() / 2) / map.tileWidth,
                        (rect.getY() + rect.getHeight() / 2) / map.tileHeight
                )
                Box2dWallEntity.create(engine, world, size, pos)
            }
        }
    }

}