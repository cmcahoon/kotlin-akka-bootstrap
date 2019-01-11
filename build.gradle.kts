plugins {
    application
    kotlin("jvm") version "1.3.10"
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.typesafe.akka:akka-actor_2.12:2.5.19")
    testImplementation("com.typesafe.akka:akka-testkit_2.12:2.5.19")
    testImplementation("junit:junit:4.12")
}

application {
    mainClassName = "AppKt"
}

tasks {
    val run by getting(JavaExec::class) {
        standardInput = System.`in`
    }
}