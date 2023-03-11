package com.alura.flix.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class Video(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    val titulo: String,
    val descricao: String,
    val url: String
)