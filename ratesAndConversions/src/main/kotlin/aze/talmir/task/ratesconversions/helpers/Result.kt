package aze.talmir.task.ratesconversions.helpers

/**
 * A generic class that holds a value with its loading_data status.
 * @param <R> defines data type the class.
 */
sealed class Result<out R : Any> {
    data class Success<out R : Any>(val data: R) : Result<R>()
    data class Error(val msg: String) : Result<Nothing>()

    override fun toString(): String = when (this) {
        is Success<*> -> "Success[data=$data]"
        is Error -> "Error[exception=$msg]"
    }
}
