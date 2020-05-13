package com.maximus.dungeonmaster.game.graphic.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.Sprite

class AnimatedSpriteComponent(val sprite: Sprite, val duration: Float, width: Float, height: Float) : Component {
    var timer = 0f

    init {
        sprite.setSize(48f, 48f)
    }
}