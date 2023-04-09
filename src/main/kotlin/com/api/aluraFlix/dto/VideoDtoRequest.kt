package com.api.aluraFlix.dto

import javax.validation.constraints.NotEmpty

data class VideoDtoRequest(
    val id: Long? = null,
    @field:NotEmpty(message = "Mensagem não pode ser em branco")
    val titulo: String,
    @field:NotEmpty
    val descricao: String,
    val url: String
)
