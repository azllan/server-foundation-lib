plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.kotlin.jvm)

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
}

group = getProp("project.group", "org.azllan")
version = getProp("project.version", "0.1.0")

base {
    archivesName.set("server-foundation")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])

            artifactId = base.archivesName.get()

            pom {
                name.set(getProp("project.name", "Azllan Server Foundation Library"))
                description.set(getProp("project.description", "Base library for Web Services"))
                url.set(getProp("project.repository.url", "https://github.com/azllan/server-foundation-lib"))

                organization {
                    name.set(getProp("project.organization.name", "Azllan"))
                    url.set(getProp("project.organization.url", "https://azllan.org"))
                }

                developers {
                    developer {
                        id.set("herberthleao")
                        name.set("Herberth Leão")
                        email.set("herberth.leao@azllan.org")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri(getProp("gpr.repository.url"))
            credentials {
                username = getProp("gpr.user")
                password = getProp("gpr.key")
            }
        }
    }
}

dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api(libs.apache.commons.math3)

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation(libs.guava)
    implementation(libs.f4b6a3.uuid.creator)
    implementation(libs.jakarta.persistence)

    // Use the Kotlin Test integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the JUnit 5 integration.
    testImplementation(libs.junit.jupiter.engine)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

fun getProp(key: String, default: String = ""): String = project.findProperty(key) as String?
    ?: System.getenv(key.uppercase().replace(".", "_"))
    ?: default