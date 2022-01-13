plugins {
    val kotlinVersion = "1.5.30"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.9.2"
}

group = "app.hive"
version = "1.0.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    runtimeOnly("net.mamoe:mirai-console:2.9.2")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.alibaba:fastjson:1.2.79")
    implementation("org.jsoup:jsoup:1.14.3")
}