import org.jetbrains.kotlin.gradle.dsl.KotlinJvmExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // see org.jetbrains.kotlin.gradle.plugin.KotlinGradleBuildServices#detectKotlinPluginLoadedInMultipleProjects
    alias { libs.plugins.kotlin.jvm } apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.1.0" apply false
    id("org.beryx.jlink") version "2.26.0" apply false
    id("com.microsoft.thrifty") version "3.1.0" apply false
    id("systems.manifold.manifold-gradle-plugin") version "0.0.2-alpha" apply false
}


group = "me.tony.practice"
version = "1.0.0"

allprojects {

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
        }
    }
}
