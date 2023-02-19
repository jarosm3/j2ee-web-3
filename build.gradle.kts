import com.bmuschko.gradle.tomcat.tasks.TomcatRun

plugins {
    java
    war
    id("com.bmuschko.tomcat") version "2.7.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val tomcatVersion by extra("8.5.16")
val log4jVersion by extra("2.19.0")

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    tomcat("org.apache.tomcat.embed:tomcat-embed-core:${tomcatVersion}")
    tomcat("org.apache.tomcat.embed:tomcat-embed-jasper:${tomcatVersion}")

    implementation("org.apache.logging.log4j:log4j-api:${log4jVersion}")
    implementation("org.apache.logging.log4j:log4j-core:${log4jVersion}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${log4jVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tomcat {
    httpProtocol = "org.apache.coyote.http11.Http11Nio2Protocol"
    ajpProtocol = "org.apache.coyote.ajp.AjpNio2Protocol"
}

tasks.getByName<TomcatRun>("tomcatRun") {
    this.outputFile = file("output.log")
}




//LEGACY
//buildscript {
//    repositories {
//        gradlePluginPortal()
//    }
//    dependencies {
//        classpath("com.bmuschko:gradle-tomcat-plugin:2.7.0")
//    }
//}
//
//apply(plugin = "com.bmuschko.tomcat")
