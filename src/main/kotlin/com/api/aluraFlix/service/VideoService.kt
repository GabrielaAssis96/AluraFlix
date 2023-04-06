package com.api.aluraFlix.service

import com.api.aluraFlix.dto.VideoDtoAtualizacaoRequest
import com.api.aluraFlix.dto.VideoDtoRequest
import com.api.aluraFlix.dto.VideoDtoResponse
import com.api.aluraFlix.mapper.VideoRequestMapper
import com.api.aluraFlix.mapper.VideoResponseMapper
import com.api.aluraFlix.model.Video
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class VideoService(
    private var listaVideos: List<Video> = ArrayList(),
    private val videoResponseMapper: VideoResponseMapper,
    private val videoRequestMapper: VideoRequestMapper
) {

    fun listar(): List<VideoDtoResponse> {
        return listaVideos.stream().map { video ->
            videoResponseMapper.map(video)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): VideoDtoResponse {
        val video = listaVideos.stream().filter { video ->
            video.id == id
        }.findFirst().get()
        return videoResponseMapper.map(video)
    }

    fun cadastrarVideo(videoDtoRequest: VideoDtoRequest) {
        val video = videoRequestMapper.map(videoDtoRequest)
        video.id = listaVideos.size.toLong() + 1
        listaVideos = listaVideos.plus(video)
    }

    fun atualizarVideo(videoDtoAtualizacao: VideoDtoAtualizacaoRequest) {
        val video = listaVideos.stream().filter { video ->
            video.id == videoDtoAtualizacao.id
        }.findFirst().get()
        listaVideos =
            listaVideos.minus(video).plus(
                Video(
                    id = videoDtoAtualizacao.id,
                    titulo = videoDtoAtualizacao.titulo,
                    descricao = videoDtoAtualizacao.descricao,
                    url = video.url
                )
            )

    }

    fun deletaVideo(id: Long) {
        val video = listaVideos.stream().filter { video ->
            video.id == id
        }.findFirst().get()
        listaVideos = listaVideos.minus(video)
    }
}