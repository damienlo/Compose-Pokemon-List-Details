package jet.pack.compose.masterdetails.data.di.annotations

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Identifies a dispatcher corresponding to input-output operations
 */
@Qualifier
@Retention(RUNTIME)
annotation class DispatcherIO