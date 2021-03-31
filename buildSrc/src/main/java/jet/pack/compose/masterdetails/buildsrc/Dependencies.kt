package jet.pack.compose.masterdetails.buildsrc

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha09"

    object Accompanist {
        private const val version = "0.6.2"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
        const val insets = "dev.chrisbanes.accompanist:accompanist-insets:$version"
    }

    object Kotlin {
        private const val version = "1.4.31"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.4.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta03"

        object Compose {
            @Suppress("MemberVisibilityCanBePrivate") // app/build.gradle
            const val version = "1.0.0-beta02"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val material = "androidx.compose.material:material:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"

        }

        object ComposeNavigation {
            private const val version = "1.0.0-alpha09"
            const val navigation = "androidx.navigation:navigation-compose:$version"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha04"
        }

        object Lifecycle {
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03"
        }

        object ConstraintLayout {
            const val constraintLayoutCompose =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"
        }
    }
}