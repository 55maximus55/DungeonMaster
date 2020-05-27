package com.maximus.dungeonmaster.game.quests.triggertargets

import com.maximus.dungeonmaster.game.quests.QuestSystem

// TODO: Весь этот класс чуть менее чем полностью является костылём, поэтому это решение нужно будет заменить на что-то приличное
class TriggerTartgets(val questSystem: QuestSystem) {

    fun activate(target: String) {
        when(target) {
            "quest0_task0" -> {
                for (i in questSystem.quests) {
                    if (i.id == "quest0") {
                        i.tasks[0].completed = true
                        i.tasks[1].unlocked = true
                        break
                    }
                }
            }
        }
    }


}