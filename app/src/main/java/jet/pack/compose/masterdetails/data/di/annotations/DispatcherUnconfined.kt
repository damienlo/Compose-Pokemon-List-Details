package jet.pack.compose.masterdetails.data.di.annotations

import javax.inject.Qualifier

/**
 * Identifies a dispatcher that is not confined to any specific thread
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DispatcherUnconfined