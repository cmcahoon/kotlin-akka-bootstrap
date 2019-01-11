import akka.actor.ActorRef
import akka.actor.ActorSystem
import com.foo.akka.Greet
import com.foo.akka.Greeter
import com.foo.akka.Printer
import com.foo.akka.WhoToGreet

fun main() {
    // Create an actor system. This is a container and lifecycle manager for actors.
    val system = ActorSystem.create("helloAkka")

    // Create actors in the new system.
    val printerActor = system.actorOf(Printer.props(), "printerActor")
    val howdyGreeter = system.actorOf(Greeter.props("Howdy", printerActor), "howdyGreeter")
    val heyGreeter = system.actorOf(Greeter.props("Hey", printerActor), "heyGreeter")
    val goodDayGreeter = system.actorOf(Greeter.props("Good day", printerActor), "goodDayGreeter")

    // Send some messages to the actors! Using `tell` is a fire and forget mechanism -- the actor will not provide a
    // response.
    howdyGreeter.tell(WhoToGreet("Partner"), ActorRef.noSender())
    howdyGreeter.tell(Greet(), ActorRef.noSender())

    howdyGreeter.tell(WhoToGreet("Cowboy"), ActorRef.noSender())
    howdyGreeter.tell(Greet(), ActorRef.noSender())

    heyGreeter.tell(WhoToGreet("You"), ActorRef.noSender())
    heyGreeter.tell(Greet(), ActorRef.noSender())

    goodDayGreeter.tell(WhoToGreet("Mr. Holmes"), ActorRef.noSender())
    goodDayGreeter.tell(Greet(), ActorRef.noSender())

    // Wait for the ENTER key. Don't do this in production. :)
    println(">>> Press ENTER to exit <<<")
    readLine()

    // Terminate the system. This will stop all of our actors and shutdown gracefully.
    system.terminate()
}