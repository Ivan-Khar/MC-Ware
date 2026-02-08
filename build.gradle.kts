plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom:${project.property("minestom_version")}")
    implementation("org.apache.logging.log4j:log4j-bom:${project.property("log4j_version")}")
    implementation("org.apache.logging.log4j:log4j-api:${project.property("log4j_version")}")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "one.theaq.mcware.MainKt"
        }
    }

    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("")
    }
}
