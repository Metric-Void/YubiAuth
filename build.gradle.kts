import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("fr.il_totore.manadrop") version "0.4.1-SNAPSHOT"
    kotlin("jvm") version "1.5.21"
}

group = "com.metricv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")
    implementation("io.ktor:ktor-client-core:1.6.2")
    implementation("io.ktor:ktor-client-cio:1.6.2")
    implementation("io.ktor:ktor-client-logging:1.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}