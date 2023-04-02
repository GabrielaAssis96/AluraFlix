package com.api.aluraFlix.controller

import com.api.aluraFlix.model.Video
import com.api.aluraFlix.service.VideoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/videos")
class VideoController(
    private val videoService: VideoService
) {

    @GetMapping
    fun getVideos(): List<Video> {
        return videoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarVideoPorId(@PathVariable id: Long): Video{
        return videoService.buscarPorId(id)
    }
}