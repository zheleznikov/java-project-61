plugins {
    java
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


application {
    mainClass.set("hexlet.code.App")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

//tasks.withType<JavaCompile> {
//    val compilerArgs = options.compilerArgs
//    compilerArgs.addAll(listOf("release = 20"))
//}

tasks.test {
    useJUnitPlatform()
}