package com.api.aluraFlix.mapper

import com.api.aluraFlix.dto.VideoDtoRequest
import com.api.aluraFlix.model.Video
import org.springframework.stereotype.Component

@Component
class VideoRequestMapper : Mapper<VideoDtoRequest, Video> {
    override fun map(video: VideoDtoRequest): Video {
        return Video(
            titulo = video.titulo,
            descricao = video.descricao,
            url = video.url
        )
    }

}
