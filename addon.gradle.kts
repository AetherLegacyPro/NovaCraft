import org.gradle.api.tasks.compile.JavaCompile

tasks.withType<JavaCompile>().configureEach {
    options.forkOptions.memoryMaximumSize = "2g"
}
