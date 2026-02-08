plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.gradleup.shadow") version "8.3.0"
}

group = "${project.property("mc_ware_group")}"
version = "${project.property("mc_ware_version")}"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guava)

    implementation("net.minestom:minestom:${project.property("minestom_version")}")
    implementation("org.apache.logging.log4j:log4j-bom:${project.property("log4j_version")}")
    implementation("org.apache.logging.log4j:log4j-api:${project.property("log4j_version")}")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.register("run", JavaExec::class.java) {
    mainClass.set("one.theaq.mcware.MainKt")
    classpath = sourceSets.main.get().runtimeClasspath
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
