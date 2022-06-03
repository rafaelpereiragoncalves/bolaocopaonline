package com.bolaocopaonline.bolaocopaonline.integration.data.service

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import java.util.Optional

interface BolaoService {

    fun create(bolao: Bolao) : Bolao

    fun getAll() : List<Bolao>

    fun getById(id: Long) : Optional<Bolao>

    fun update(id: Long, bolao: Bolao) : Optional<Bolao>

    fun delete(id: Long)
}