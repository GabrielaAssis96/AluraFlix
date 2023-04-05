package com.api.aluraFlix.service

import com.api.aluraFlix.dto.VideoDtoRequest
import com.api.aluraFlix.dto.VideoDtoResponse
import com.api.aluraFlix.model.Video
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class VideoService(private var listaVideos: List<Video> = ArrayList()) {

    fun listar(): List<VideoDtoResponse> {
        return listaVideos.stream().map {
            VideoDtoResponse(
                id = it.id,
                titulo = it.titulo,
                descricao = it.descricao,
                url = it.url
            )
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): VideoDtoResponse {
        val video = listaVideos.stream().filter { video ->
            video.id == id
        }.findFirst().get()
        return VideoDtoResponse(
            id = video.id, titulo = video.titulo, descricao = video.descricao, url = video.url

        )
    }

    fun cadastrarVideo(videoDtoRequest: VideoDtoRequest) {
        listaVideos = listaVideos.plus(
            Video(
                id = listaVideos.size.toLong() + 1,
                titulo = videoDtoRequest.titulo,
                descricao = videoDtoRequest.descricao,
                url = videoDtoRequest.url
            )
        )
    }
}