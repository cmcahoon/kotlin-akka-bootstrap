import akka.actor.typed.ActorSystem
import com.foo.akka.Greet
import com.foo.akka.Greeter

fun main() {
    // Create an actor system. This is a container and lifecycle manager for actors.
    val system = ActorSystem.create(Greeter.create(), "greetings")
    system.tell(Greet("Good day", "Mr. Holmes"))
    system.tell(Greet("Howdy", "Partner"))
    system.tell(Greet("Howdy", "Cowboy"))
    system.tell(Greet("Hey", "You"))

    // Terminate the system. This will stop all of our actors and shutdown gracefully.
    Thread.sleep(2000)
    system.terminate()
}