package com.maximus.dungeonmaster.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.maximus.dungeonmaster.Main
import java.util.*

/** Launches the desktop (LWJGL3) application.  */
fun main(args: Array<String>) {
    val configuration = defaultConfiguration
    Lwjgl3Application(Main(Locale.getDefault()), configuration)
}

private val defaultConfiguration = Lwjgl3ApplicationConfiguration().apply {
    setTitle("DungeonMaster")
    setWindowedMode(640, 480)
    setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
}