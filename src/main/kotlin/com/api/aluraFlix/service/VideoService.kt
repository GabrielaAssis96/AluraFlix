package com.api.aluraFlix.service

import com.api.aluraFlix.model.Video
import org.springframework.stereotype.Service

@Service
class VideoService(private var listaVideos: List<Video>) {

    init {
        val video1 = (Video
            (
            id = 1,
            titulo = "COISAS DA MODA",
            descricao = "Tendencias da moda 2000 ",
            url = "/"
        ))

        val video2 = (Video
            (
            id = 2,
            titulo = "RECEITA DE BOLO",
            descricao = "Receita da vovó Cicera",
            url = "/"
        ))

        val video3 = (Video
            (
            id = 3,
            titulo = "OS MELHORES FILMES DE COMÉDIA",
            descricao = "Listando os melhores filmes do ano!",
            url = "/"
        ))

        listaVideos = listOf(video1, video2, video3)
    }

    fun listar(): List<Video> {
        return listaVideos
    }

    fun buscarPorId(id: Long): Video {
        return listaVideos.stream().filter { video ->
            video.id == id
        }.findFirst().get()
    }
}