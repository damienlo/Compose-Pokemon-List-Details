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

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        object Adapter {
            private const val version = "0.9.2"
            const val coroutinesAdapter =
                "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${version}"
        }
    }

    object Moshi {
        private const val version = "1.9.3"
        const val moshi = "com.squareup.moshi:moshi:${version}"
        const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${version}"
        object Converter {
            private const val version = "2.9.0"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${version}"
        }
    }

    object Dagger {
        private const val version = "2.33-beta"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${version}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${version}"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${version}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${version}"
        object AndroidX {
            private const val version = "1.0.0-alpha03"
            const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${version}"
        }
        object Navigation {
            private const val version = "1.0.0-alpha01"
            const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${version}"
        }
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
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val material = "androidx.compose.material:material:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
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

        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            object Espresso {
                private const val version = "3.3.0"
                const val espressoCore = "androidx.test.espresso:espresso-core:${version}"
            }

            object Arch {
                private const val version = "2.1.0"
                const val core = "androidx.arch.core:core-testing:${version}"
            }
        }
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

    object Mockito {
        private const val kotlinVersion = "3.1.0"
        private const val inlineVersion = "3.8.0"
        const val kotlin = "org.mockito.kotlin:mockito-kotlin:${kotlinVersion}"
        const val inline = "org.mockito:mockito-inline:${inlineVersion}"
    }

}