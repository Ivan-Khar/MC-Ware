plugins {
    alias(libs.plugins.kotlin.jvm)

    application
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.guava)
    implementation("net.minestom:minestom:${project.property("minestom_version")}")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.1.0")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "one.theaq.mcware.MainKt"
}
