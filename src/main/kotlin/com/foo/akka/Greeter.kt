package com.foo.akka

import akka.actor.typed.ActorRef
import akka.actor.typed.Behavior
import akka.actor.typed.javadsl.AbstractBehavior
import akka.actor.typed.javadsl.ActorContext
import akka.actor.typed.javadsl.Behaviors
import akka.actor.typed.javadsl.Receive

// Message types. These should be immutable because they are shared between threads. Kotlin data classes are perfect for
// this. Be sure to use `val`!
class Greet(val salutation: String, val who: String)

// Greeter is an actor that creates a customized greeting!
class Greeter(context: ActorContext<Greet>) : AbstractBehavior<Greet>(context) {
    val printer: ActorRef<Greeting>

    init {
        printer = context.spawn(Printer.create(), "printer")
    }

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
        printer.tell(Greeting("${msg.salutation}, ${msg.who}!"))
        return this
    }
}