package com.api.aluraFlix.mapper

interface Mapper<T, U> {

    fun map(video: T): U
}