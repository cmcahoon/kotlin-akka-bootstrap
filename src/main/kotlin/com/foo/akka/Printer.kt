package com.foo.akka

import akka.actor.AbstractActor
import akka.actor.Props
import akka.event.Logging

// Message types. These should be immutable because they are shared between threads. Kotlin data classes are perfect for
// this. Be sure to use `val`!
data class Greeting(val message: String)

// Printer is an actor that prints arbitrary strings to the console!
class Printer : AbstractActor() {

    private val log = Logging.getLogger(context.system, this)

    // In Java, `props` would be a static method on the class. In Kotlin, we can define it as a companion object so it
    // can be referenced as `Greeter.props(...)`.
    companion object {
        fun props() : Props {
            return Props.create(Printer::class.java) {
                Printer()
            }
        }
    }

    // Every actor has to override this function. Akka provides an easy to use matcher which routes message types to the
    // appropriate handler functions.
    override fun createReceive(): Receive {
        return receiveBuilder()
                .match(Greeting::class.java, this::onGreeting) // Handle Greeting messages
                .build()
    }

    private fun onGreeting(msg: Greeting) {
        log.info(msg.message)
    }

}