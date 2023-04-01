package com.api.aluraFlix.service

import com.api.aluraFlix.model.Video
import org.springframework.stereotype.Service

@Service
class VideoService {
    fun listar(): List<Video> {
        val video = (Video(id = null, titulo = "Morango", descricao = "Criando morangos", url = "/"))

        return listOf(video, video, video)
    }
}