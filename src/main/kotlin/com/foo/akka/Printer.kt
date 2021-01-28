package com.foo.akka

import akka.actor.typed.Behavior
import akka.actor.typed.javadsl.AbstractBehavior
import akka.actor.typed.javadsl.ActorContext
import akka.actor.typed.javadsl.Behaviors
import akka.actor.typed.javadsl.Receive

// Message types. These should be immutable because they are shared between threads. Kotlin data classes are perfect for
// this. Be sure to use `val`!
data class Greeting(val message: String)

// Printer is an actor that prints arbitrary strings to the console!
class Printer(context: ActorContext<Greeting>) : AbstractBehavior<Greeting>(context) {

    // In Java, `props` would be a static method on the class. In Kotlin, we can define it as a companion object so it
    // can be referenced as `Greeter.props(...)`.
    companion object {
        fun create() : Behavior<Greeting> {
            return Behaviors.setup(::Printer)
        }
    }

    // Every actor has to override this function. Akka provides an easy to use matcher which routes message types to the
    // appropriate handler functions.
    override fun createReceive(): Receive<Greeting> {
        return newReceiveBuilder().onMessage(Greeting::class.java, this::onGreeting).build()
    }

    private fun onGreeting(msg: Greeting): Behavior<Greeting>{
        println(msg.message)
        return this
    }

}