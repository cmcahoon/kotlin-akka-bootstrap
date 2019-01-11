package com.foo.akka

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.Props

// Message types. These should be immutable because they are shared between threads. Kotlin data classes are perfect for
// this. Be sure to use `val`!
data class WhoToGreet(val who: String)
class Greet

// Greeter is an actor that creates a customized greeting!
class Greeter(private val message: String, private val printer: ActorRef) : AbstractActor() {

    private var who = ""
    private var greeting = ""

    // In Java, `props` would be a static method on the class. In Kotlin, we can define it as a companion object so it
    // can be referenced as `Greeter.props(...)`.
    companion object {
        fun props(message: String, printer: ActorRef) : Props {
            return Props.create(Greeter::class.java) {
                Greeter(message, printer)
            }
        }
    }

    // Every actor has to override this function. Akka provides an easy to use matcher which routes message types to the
    // appropriate handler functions.
    override fun createReceive(): Receive {
        return receiveBuilder()
                .match(WhoToGreet::class.java, this::onWhoToGreet) // Handle WhoToGreet messages
                .match(Greet::class.java, this::onGreet)           // Handle Greet messages
                .build()

    }

    private fun onWhoToGreet(msg: WhoToGreet) {
        who = msg.who
        greeting = "${message}, ${who}!"
    }

    private fun onGreet(msg: Greet) {
        printer.tell(Greeting(greeting), self)
    }
}