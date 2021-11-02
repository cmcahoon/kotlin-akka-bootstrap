# kotlin-akka-bootstrap
Clone this repository to have Kotlin + Akka up and running in no time!

[Akka](https://akka.io/) is a toolkit for Scala and Java to build scalable systems with actors and streams.

[Kotlin](https://kotlinlang.org/) is a language from JetBrains that, among many other features, is interoperable with Java and significantly reduces boilerplate. 

## Tool Versions

| Tool | Version | Notes |
|------|---------|-------|
| Kotlin | 1.5.31 | |
| Gradle | 6.7.1 | Use the wrapper -- no need to install locally |
| Akka | 2.6.17 | |

## Usage
The following instructions are for command line interaction. IntelliJ has tight integration with Gradle if you prefer the GUI.

### Compile
From the project root run: `./gradlew build`

### Run
From the project root run:
```bash
$ ./gradlew run

> Task :run
10:14:10.871 [greetings-akka.actor.default-dispatcher-5] INFO com.foo.akka.Printer - Good day, Mr. Holmes!
10:14:10.871 [greetings-akka.actor.default-dispatcher-5] INFO com.foo.akka.Printer - Howdy, Partner!
10:14:10.871 [greetings-akka.actor.default-dispatcher-5] INFO com.foo.akka.Printer - Howdy, Cowboy!
10:14:10.871 [greetings-akka.actor.default-dispatcher-5] INFO com.foo.akka.Printer - Hey, You!

BUILD SUCCESSFUL in 5s
3 actionable tasks: 2 executed, 1 up-to-date
```