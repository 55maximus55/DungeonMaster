package com.maximus.dungeonmaster.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.math.Vector2
import com.maximus.dungeonmaster.BlankScreen
import com.maximus.dungeonmaster.box2d.systems.Box2dWorldDebugRenderSystem
import com.maximus.dungeonmaster.box2d.systems.Box2dWorldUpdateSystem
import com.maximus.dungeonmaster.box2d.utils.Box2dWallsCreator
import com.maximus.dungeonmaster.objects.PlayerEntity
import com.maximus.dungeonmaster.tiledmap.EntityCreatorFromTiledMap
import com.maximus.dungeonmaster.tiledmap.OrthogonalTiledMapRenderSystem
import ktx.ashley.add
import ktx.box2d.createWorld
import ktx.tiled.tileHeight
import ktx.vis.table

class GameScreen : BlankScreen() {

    override val view = table {
        top()
        left()
        setFillParent(true)

        label("Game Screen")
    }

    val camera = OrthographicCamera().apply {
        setToOrtho(false)
        position.x = 0f
        position.y = 0f
        update()
    }

    val map: TiledMap = TmxMapLoader().load("maps/map1.tmx")
    val PPM = map.tileHeight.toFloat()
    val world = createWorld(Vector2(0f, 0f))
    val fov = 48f * 16

    init {
        Box2dWallsCreator.createWalls(engine, map, world)
        EntityCreatorFromTiledMap.createEntities(engine, world, map)
        engine.add {
            addSystem(Box2dWorldUpdateSystem(world))

            addSystem(OrthogonalTiledMapRenderSystem(map, camera))
            addSystem(Box2dWorldDebugRenderSystem(world, camera, PPM))
        }
    }

    override fun resize(width: Int, height: Int) {
        camera.apply {
            viewportWidth = fov * Gdx.graphics.width.toFloat() / Gdx.graphics.height.toFloat()
            viewportHeight = fov
            update()
        }
    }

    override fun dispose() {
        map.dispose()
    }

}