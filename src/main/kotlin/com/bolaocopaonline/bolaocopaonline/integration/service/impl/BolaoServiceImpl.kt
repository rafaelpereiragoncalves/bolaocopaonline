package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.BolaoRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTOForm
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.BolaoFormMapper
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.BolaoMapper
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import com.bolaocopaonline.bolaocopaonline.integration.service.BolaoService
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class BolaoServiceImpl(
    private val repository: BolaoRepository,
    private var boloes: List<Bolao>,
    private val bolaoMapper: BolaoMapper,
    private val bolaoFormMapper: BolaoFormMapper
) : BolaoService {

    override fun create(bolaoDTOForm: BolaoDTOForm): BolaoDTO {
        val bolao = bolaoFormMapper.map(bolaoDTOForm)
        bolao.id = boloes.size.toLong() + 1
        boloes = boloes.plus(bolao)
        repository.save(bolao)
        return bolaoMapper.map(bolao)
    }

    override fun getAll(): List<BolaoDTO> {
        return boloes.stream().map {
                b -> bolaoMapper.map(b)
        }.collect(Collectors.toList())
    }

    override fun getById(id: Long): Optional<Bolao> {
        return repository.findById(id)
    }

    override fun update(id: Long, bolao: Bolao): Optional<Bolao> {
        val optional = getById(id)

        return optional.map {
            val bolaoToUpdate = it.copy(
                name = bolao.name
            )
            repository.save(bolaoToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found.") }
    }
}