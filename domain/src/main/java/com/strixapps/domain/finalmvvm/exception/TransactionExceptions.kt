package com.strixapps.domain.finalmvvm.exception

sealed class TransactionExceptions : Exception() {
        class NetworkError : TransactionExceptions()
        class HttpError(val code: Int, override val message: String) : TransactionExceptions()
        class GenericError(override val message: String) : TransactionExceptions()
}