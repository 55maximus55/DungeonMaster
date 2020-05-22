package com.maximus.dungeonmaster.game.quests

import com.badlogic.gdx.Gdx


class QuestSystem {

    val quests = ArrayList<Quest>()
    var currentQuest: Quest? = null

    init {
        val files = Gdx.files.internal("quests/").list()
        for (file in files) {
            quests.add(QuestParser.load(file))
        }
    }

}