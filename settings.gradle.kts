dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
    plugins {
        id("com.google.gms.google-services") version "4.4.2" apply false
    }
}

rootProject.name = "Book Corner" // optional: change to Book Corner here if you want
include(":app")
