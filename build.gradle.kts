import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("com.metricv.ManadropFix") version "0.5-SNAPSHOT"
    kotlin("jvm") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.metricv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://gitlab.com/api/v4/projects/28955808/packages/maven")
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

spigot {
    desc {
        named("YubiAuth")
        version("1.0-SNAPSHOT")
        authors("MetricVoid")
        main("com.metricv.yubiauth.PluginMain")

        command {
            named("yubiauth")
            description("YubiAuth main command")
        }

        permission {
            named("yubiauth.*")
            description("All permission for YubiAuth. YOU DO NOT WANT TO USE THIS.")
            defaultType("deny_player")
            child {
                named("yubiauth.unauthed.*")
                inherit(false)
            }
            child {
                named("yubiaht.admin.*")
                inherit(true)
            }
        }

        permission {
            named("yubiauth.unauthed.*")
            description("Allow some player behaviors when not authenticated.")
            defaultType("deny_player")

            child {
                named("yubiauth.unauthed.chat")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.move")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.swapitem")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.armorstand")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.invclick")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.openinv")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.consume")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.pickupitem")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.dropitem")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.holditem")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.interact")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.interactentity")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.hit")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.shear")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.fish")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.sleep")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.editbook")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.changesign")
                inherit(true)
            }

            child {
                named("yubiauth.unauthed.command")
                inherit(true)
            }
        }

        permission {
            named("yubiauth.unauthed.chat")
            description("Allow players to chat when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.move")
            description("Allow players to move when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.swapitem")
            description("Allow players to swap item in hands when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.armorstand")
            description("Allow players to modify an armor stand when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.invclick")
            description("Allow players to click inventory when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.openinv")
            description("Allow players to open inventory when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.consume")
            description("Allow players to consume food when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.pickupitem")
            description("Allow players pick up an item on the ground when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.dropitem")
            description("Allow players drop an item to the ground when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.holditem")
            description("Allow players to hold an item when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.interact")
            description("Allow players to interact with a block when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.interactentity")
            description("Allow players to interact with an entity when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.hit")
            description("Allow players to hit an animal or player when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.shear")
            description("Allow players to shear sheeps when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.fish")
            description("Allow players to fish when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.sleep")
            description("Allow players to sleep on beds when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.editbook")
            description("Allow players to edit books when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.changesign")
            description("Allow players to edit signs when unauthenticated.")
            defaultType("deny_player")
        }

        permission {
            named("yubiauth.unauthed.command")
            description("Allow players to execute commands when unauthenticated.")
            defaultType("deny_player")
        }
    }
}