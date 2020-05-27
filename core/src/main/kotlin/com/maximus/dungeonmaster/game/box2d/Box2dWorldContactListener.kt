package com.maximus.dungeonmaster.game.box2d

import com.badlogic.gdx.physics.box2d.Contact
import com.badlogic.gdx.physics.box2d.ContactImpulse
import com.badlogic.gdx.physics.box2d.ContactListener
import com.badlogic.gdx.physics.box2d.Manifold
import com.maximus.dungeonmaster.game.NameComponent
import com.maximus.dungeonmaster.game.quests.triggertargets.TriggerTargetName
import com.maximus.dungeonmaster.game.quests.triggertargets.TriggerTartgets

class Box2dWorldContactListener(val triggerTartgets: TriggerTartgets) : ContactListener {

    override fun beginContact(contact: Contact?) {
        val entityA = (contact!!.fixtureA.body.userData as Box2dBodyData).entity
        val entityB = (contact!!.fixtureB.body.userData as Box2dBodyData).entity

        if (entityA.getComponent(NameComponent::class.java).name == "trigger" && entityB.getComponent(NameComponent::class.java).name == "player") {
            triggerTartgets.activate(entityA.getComponent(TriggerTargetName::class.java).name)
        }
    }

    override fun endContact(contact: Contact?) {
        val entityA = (contact!!.fixtureA.body.userData as Box2dBodyData).entity
        val entityB = (contact!!.fixtureB.body.userData as Box2dBodyData).entity
    }

    override fun preSolve(contact: Contact?, oldManifold: Manifold?) {
        val entityA = (contact!!.fixtureA.body.userData as Box2dBodyData).entity
        val entityB = (contact!!.fixtureB.body.userData as Box2dBodyData).entity

        if (entityA.getComponent(NameComponent::class.java).name == "trigger" && entityB.getComponent(NameComponent::class.java).name == "player") {
            contact.isEnabled = false
        }
    }

    override fun postSolve(contact: Contact?, impulse: ContactImpulse?) {
        val entityA = (contact!!.fixtureA.body.userData as Box2dBodyData).entity
        val entityB = (contact!!.fixtureB.body.userData as Box2dBodyData).entity
    }

}