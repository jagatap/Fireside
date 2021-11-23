package com.mywishlistindia.utils.resource

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val responseCode: Int = 200
) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(msg: String?, responseCode: Int = 200): Resource<T> {
            return Resource(Status.ERROR, null, msg, responseCode)
        }

        fun <T> loading(): Resource<T> {
            return Resource(
                Status.LOADING,
                null,
                null
            )
        }

    }

}