# kotlin-akka-bootstrap
Clone this repository to have Kotlin + Akka up and running in no time!

[Akka](https://akka.io/) is a toolkit for Scala and Java to build scalable systems with actors and streams.

[Kotlin](https://kotlinlang.org/) is a language from JetBrains that, among many other features, is interoperable with Java and significantly reduces boilerplate. 

## Tool Versions

| Tool | Version | Notes |
|------|---------|-------|
| Kotlin | 1.4.21 | |
| Gradle | 6.7.1 | Use the wrapper -- no need to install locally |
| Akka | 2.5.19 | |

## Usage
The following instructions are for command line interaction. IntelliJ has tight integration with Gradle if you prefer the GUI.

### Compile
From the project root run: `./gradlew build`

### Run
From the project root run:
```bash
$ ./gradlew run

> Task :run
>>> Press ENTER to exit <<<
[INFO] [01/10/2019 21:04:17.201] [helloAkka-akka.actor.default-dispatcher-4] [akka://helloAkka/user/printerActor] Good day, Mr. Holmes!
[INFO] [01/10/2019 21:04:17.202] [helloAkka-akka.actor.default-dispatcher-4] [akka://helloAkka/user/printerActor] Howdy, Partner!
[INFO] [01/10/2019 21:04:17.202] [helloAkka-akka.actor.default-dispatcher-4] [akka://helloAkka/user/printerActor] Howdy, Cowboy!
[INFO] [01/10/2019 21:04:17.202] [helloAkka-akka.actor.default-dispatcher-4] [akka://helloAkka/user/printerActor] Hey, You!

# Press ENTER here!

BUILD SUCCESSFUL in 5s
3 actionable tasks: 2 executed, 1 up-to-date
```