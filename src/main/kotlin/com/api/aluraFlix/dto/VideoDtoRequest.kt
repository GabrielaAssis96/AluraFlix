package com.api.aluraFlix.dto

data class VideoDtoRequest(
    val id: Long? = null,
    val titulo: String = "",
    val descricao: String = "",
    val url: String = ""
)
