package com.api.aluraFlix.controller

import com.api.aluraFlix.dto.VideoDtoAtualizacaoRequest
import com.api.aluraFlix.dto.VideoDtoRequest
import com.api.aluraFlix.dto.VideoDtoResponse
import com.api.aluraFlix.service.VideoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun cadastrarVideo(
        @RequestBody @Valid videoDtoRequest: VideoDtoRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<VideoDtoResponse> {
        val videoDtoResponse = videoService.cadastrarVideo(videoDtoRequest)
        val uri = uriBuilder.path("/videos/${videoDtoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(videoDtoResponse)
    }

    @PutMapping
    fun atualizarVideo(@RequestBody @Valid videoDtoAtualizacaoRequest: VideoDtoAtualizacaoRequest): ResponseEntity<VideoDtoResponse> {
        val videoResponseAtualizado = videoService.atualizarVideo(videoDtoAtualizacaoRequest)
        return ResponseEntity.ok(videoResponseAtualizado)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletaVideo(@PathVariable id: Long) {
        videoService.deletaVideo(id)
    }
}
