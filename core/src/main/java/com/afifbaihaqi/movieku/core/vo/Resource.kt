package com.afifbaihaqi.movieku.core.vo

data class Resource<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> Success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)

        fun <T> Error(msg: String?, data: T?): Resource<T> = Resource(Status.ERROR, data, msg)

        fun <T> Loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
    }
}