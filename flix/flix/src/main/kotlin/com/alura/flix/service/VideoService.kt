package com.alura.flix.service

import com.alura.flix.repository.VideoRepository
import org.springframework.stereotype.Service

@Service
class VideoService(private var videosRepository: VideoRepository) {

    fun buscarPorId(id: Long){
        val video = videosRepository.findById(id)
    }
}