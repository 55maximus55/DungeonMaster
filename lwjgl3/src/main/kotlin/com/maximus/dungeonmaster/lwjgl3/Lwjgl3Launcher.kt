package com.maximus.dungeonmaster.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics.Lwjgl3DisplayMode
import com.maximus.dungeonmaster.Main
import org.lwjgl.glfw.GLFW
import java.util.*

/** Launches the desktop (LWJGL3) application.  */
fun main(args: Array<String>) {
    Lwjgl3Application(Main(Locale.getDefault()), getConfiguration(args))
}

private fun getConfiguration(args: Array<String>): Lwjgl3ApplicationConfiguration {
    var width = 800
    var height = 600
    var borderless = false

    for (arg in args) {
        if (arg.contains("w")) width = arg.substring(1).toInt()
        if (arg.contains("h")) height = arg.substring(1).toInt()
        if (arg == "b") borderless = true
        if (arg == "f") {
            borderless = true
            val displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode()
            width = displayMode.width
            height = displayMode.height
        }
    }

    return Lwjgl3ApplicationConfiguration().apply {
        setTitle("DungeonMaster")
        setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")

        setWindowedMode(width, height)
        setDecorated(!borderless)
    }
}