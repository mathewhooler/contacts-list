plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("junit:junit:4.13.2")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
kotlin {
  jvmToolchain(8)
}

