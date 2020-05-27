package com.maximus.dungeonmaster.game.quests

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.Color
import com.kotcrab.vis.ui.widget.VisLabel
import com.kotcrab.vis.ui.widget.VisTable

class QuestUpdateUISystem(val table: VisTable, var questSystem: QuestSystem) : EntitySystem() {

    override fun update(deltaTime: Float) {
        val quest = questSystem.currentQuest
        table.apply {
            clear()
            if (quest != null) {
                add(VisLabel("Quest: ${quest.name}"))
                for (i in quest.tasks) {
                    if (i.unlocked) {
                        row()
                        add(VisLabel("Task: ${i.name}").apply {
                            if (i.failed) color = Color.RED
                            else if (i.completed) color = Color.GREEN
                        })
                    }
                }
            }
        }
    }

}