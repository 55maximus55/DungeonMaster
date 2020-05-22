package com.maximus.dungeonmaster.game.quests

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.utils.JsonReader

class QuestParser {
    companion object {

        fun load(name: String): Quest {
            val fileHandle = Gdx.files.internal("quests/${name}.json")
            return load(fileHandle)
        }

        fun load(fileHandle: FileHandle?): Quest {
            val jsonQuest = JsonReader().parse(fileHandle)
            val quest = Quest()

            quest.name = jsonQuest.getString("name")
            quest.description = jsonQuest.getString("description")

            for (i in 0 until jsonQuest.get("tasks").size) {
                val task = Task()
                val jsonTask = jsonQuest.get("tasks")[i]

                task.name = jsonTask.getString("name")
                task.completed = jsonTask.getBoolean("completed")
                task.failed = jsonTask.getBoolean("failed")
                task.unlocked = jsonTask.getBoolean("unlocked")

                quest.tasks.add(task)
            }
            return quest
        }

    }
}