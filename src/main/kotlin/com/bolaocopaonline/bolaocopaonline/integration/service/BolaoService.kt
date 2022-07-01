package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import org.springframework.stereotype.Service
import java.util.Optional

interface BolaoService {

    fun create(bolaoDTO: BolaoDTO) : BolaoDTO

    fun getAll() : List<Bolao>

    fun getById(id: Long) : Optional<Bolao>

    fun update(id: Long, bolao: Bolao) : Optional<Bolao>

    fun delete(id: Long)
}