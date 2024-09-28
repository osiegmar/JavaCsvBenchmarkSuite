import me.champeau.jmh.JMHTask

plugins {
    java
    id("me.champeau.jmh") version "0.7.2" apply false
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

dependencies {
    implementation("org.openjdk.jmh:jmh-core:1.37")
    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

allprojects {
    apply(plugin = "checkstyle")
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "me.champeau.jmh")

    dependencies {
        compileOnly(rootProject)
        testImplementation(rootProject)

        testImplementation(platform("org.junit:junit-bom:5.9.3"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.named<JMHTask>("jmh") {
        warmupIterations = 2
        iterations = 1
        benchmarkMode = listOf("thrpt")
        fork = 8
        failOnError = true
        operationsPerInvocation = 1
        resultFormat = "CSV"
    }

    project.afterEvaluate {
        tasks.register("depsize") {
            listConfigurationDependencies(
                project.name,
                project.layout.buildDirectory.get(),
                configurations.runtimeClasspath.get()
            )
        }
    }
}

fun listConfigurationDependencies(projectName: String, buildDir: Directory, configuration: Configuration) {
    val formatStr = "%,10.2f"

    val size = configuration.sumOf { it.length() } / 1024.0

    val reportFile = file("${buildDir}/tmp/deps.txt")
    mkdir(reportFile.parentFile)

    val out = StringBuilder()
    if (size > 0) {
        reportFile.writeText("$projectName,${Math.round(size)}\n")
        out.append("Total dependencies size:".padEnd(65))
        out.append("${String.format(formatStr, size)} KiB\n\n")

        configuration.sortedBy { -it.length() }
            .forEach {
                out.append(it.name.padEnd(65))
                out.append("${String.format(formatStr, (it.length() / 1024.0))} KiB\n")
            }
    } else {
        out.append("No dependencies found")
    }
    out.append("-".repeat(79))
    println(out)
    println()
}
