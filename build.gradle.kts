plugins {
    application
    kotlin("jvm") version "1.5.31"
}

val akkaVersion = "2.6.17"
val scalaVersion = "2.13"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(platform("com.typesafe.akka:akka-bom_${scalaVersion}:${akkaVersion}"))

    implementation(kotlin("stdlib"))
    implementation("com.typesafe.akka:akka-actor-typed_${scalaVersion}")
    testImplementation("com.typesafe.akka:akka-testkit_${scalaVersion}")
    testImplementation("junit:junit:4.13.2")

    runtimeOnly("ch.qos.logback:logback-classic:1.2.6")
}

application {
    mainClass.set("AppKt")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}