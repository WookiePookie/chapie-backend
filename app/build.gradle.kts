plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation("io.ktor:ktor-server-netty:1.6.4")
    implementation("io.ktor:ktor-websockets:1.6.4")
}