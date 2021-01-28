import akka.actor.ActorRef
import akka.actor.typed.ActorSystem
import com.foo.akka.Greet
import com.foo.akka.Greeter
import com.foo.akka.Printer
import com.foo.akka.WhoToGreet

fun main() {
    // Create an actor system. This is a container and lifecycle manager for actors.
    val system = ActorSystem.create(Greeter.create(), "greetings")
    system.tell(Greet())

    // Wait for the ENTER key. Don't do this in production. :)
    println(">>> Press ENTER to exit <<<")
    readLine()

    // Terminate the system. This will stop all of our actors and shutdown gracefully.
    system.terminate()
}