package com.maximus.dungeonmaster.game.quests

class Quest {

    var id: String = ""
    var name: String = ""
    var unlocked: Boolean = false
    var completed: Boolean = false
    var failed: Boolean = false
    var tasks = ArrayList<Task>()

}