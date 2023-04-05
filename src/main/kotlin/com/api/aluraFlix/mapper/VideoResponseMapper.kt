package com.api.aluraFlix.mapper

import com.api.aluraFlix.dto.VideoDtoResponse
import com.api.aluraFlix.model.Video
import org.springframework.stereotype.Component

@Component
class VideoResponseMapper : Mapper<Video, VideoDtoResponse> {
    override fun map(video: Video): VideoDtoResponse {
        return VideoDtoResponse(
            id = video.id,
            titulo = video.titulo,
            descricao =  video.descricao,
            url = video.url
        )
    }
}