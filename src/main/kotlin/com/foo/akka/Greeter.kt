package com.foo.akka

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.Props
import akka.actor.typed.Behavior
import akka.actor.typed.javadsl.AbstractBehavior
import akka.actor.typed.javadsl.ActorContext
import akka.actor.typed.javadsl.Behaviors
import akka.actor.typed.javadsl.Receive

// Message types. These should be immutable because they are shared between threads. Kotlin data classes are perfect for
// this. Be sure to use `val`!
data class WhoToGreet(val who: String)
class Greet

// Greeter is an actor that creates a customized greeting!
class Greeter(context: ActorContext<Greet>) : AbstractBehavior<Greet>(context) {
    // In Java, `props` would be a static method on the class. In Kotlin, we can define it as a companion object so it
    // can be referenced as `Greeter.props(...)`.
    companion object {
        fun create() : Behavior<Greet> {
            return Behaviors.setup(::Greeter)
        }
    }

    // Every actor has to override this function. Akka provides an easy to use matcher which routes message types to the
    // appropriate handler functions.
    override fun createReceive(): Receive<Greet> {
        return newReceiveBuilder().onMessage(Greet::class.java, this::onGreet).build()

    }

    private fun onGreet(msg: Greet) : Behavior<Greet> {
        val printer = context.spawn(Printer.create(), "printer")
        printer.tell(Greeting("Hello, Akka!"))
        return this
    }
}