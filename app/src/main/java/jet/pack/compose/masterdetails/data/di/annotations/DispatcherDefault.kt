package jet.pack.compose.masterdetails.data.di.annotations

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Identifies a dispatcher corresponding to CPU intensive tasks
 */
@Qualifier
@Retention(RUNTIME)
annotation class DispatcherDefault