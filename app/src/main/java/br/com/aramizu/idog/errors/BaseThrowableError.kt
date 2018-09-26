package br.com.aramizu.idog.errors

open class BaseThrowableError: Throwable() {
    var errorMessage: String? = null
}