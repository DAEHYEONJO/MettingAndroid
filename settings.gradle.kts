pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("deps") {
            from(files("../Meetiing/gradle/dependencies.toml"))
        }
    }
}
rootProject.name = "Meetiing"
include (":app")
