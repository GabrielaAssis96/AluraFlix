package com.alura.flix.repository

import com.alura.flix.model.Video
import org.springframework.data.jpa.repository.JpaRepository

interface VideoRepository: JpaRepository<Video, Long>