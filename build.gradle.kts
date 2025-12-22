plugins {
    java
    application
    id("org.javamodularity.moduleplugin") version "1.8.15"
    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.beryx.jlink") version "2.25.0"
    id("org.springframework.boot") version "4.0.0"
    id("io.spring.dependency-management") version "1.1.7"
}


group = "br.com.banco"
version = "1.0-SNAPSHOT"

javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}


application {

    mainModule.set("br.com.banco")
    mainClass.set("br.com.banco.App")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
  

}

tasks.test {
    useJUnitPlatform()
}

jlink {
    imageZip.set(layout.buildDirectory.file("/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "app"
    }
}