plugins {
    application
}

dependencies {
    implementation("com.google.inject:guice:5.1.0")
    implementation("org.slf4j:slf4j-api:2.0.3")
    implementation("org.slf4j:slf4j-simple:2.0.3")
}

application {
    mainClass.set("ru.vk.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
