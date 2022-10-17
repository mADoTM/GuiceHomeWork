plugins {
    application
}

dependencies {
    implementation("com.google.inject:guice:5.1.0")
}

application {
    mainClass.set("ru.vk.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
