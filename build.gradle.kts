plugins {
    java
}

allprojects {
    group = "ru.vk"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    dependencies {
        implementation("org.jetbrains:annotations:20.1.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}