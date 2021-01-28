plugins {
    application
    kotlin("jvm") version "1.4.21"
}

val akka_version = "2.6.11"
val scala_version = "2.13"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(platform("com.typesafe.akka:akka-bom_${scala_version}:${akka_version}"))

    implementation(kotlin("stdlib"))
    implementation("com.typesafe.akka:akka-actor-typed_${scala_version}")
    testImplementation("com.typesafe.akka:akka-testkit_${scala_version}")
    testImplementation("junit:junit:4.12")
}

application {
    mainClass.set("AppKt")
}

tasks {
    val run by getting(JavaExec::class) {
        standardInput = System.`in`
    }
}