package com.api.aluraFlix.controller

import com.api.aluraFlix.dto.VideoDtoRequest
import com.api.aluraFlix.dto.VideoDtoResponse
import com.api.aluraFlix.service.VideoService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/videos")
class VideoController(
    private val videoService: VideoService
) {

    @GetMapping
    fun getVideos(): List<VideoDtoResponse> {
        return videoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarVideoPorId(@PathVariable id: Long): VideoDtoResponse {
        return videoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrarVideo(@RequestBody @Valid videoDtoRequest: VideoDtoRequest) {
        videoService.cadastrarVideo(videoDtoRequest)
    }
}