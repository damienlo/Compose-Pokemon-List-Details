package jet.pack.compose.masterdetails.data.di.annotations

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Identifies a dispatcher corresponding to main/UI thread operations.
 */
@Qualifier
@Retention(RUNTIME)
annotation class DispatcherMain