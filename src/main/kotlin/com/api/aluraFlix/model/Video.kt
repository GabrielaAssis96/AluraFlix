package com.api.aluraFlix.model

data class Video(
    var id: Long? = null,
    val titulo: String = "",
    val descricao: String = "",
    val url: String = ""
)