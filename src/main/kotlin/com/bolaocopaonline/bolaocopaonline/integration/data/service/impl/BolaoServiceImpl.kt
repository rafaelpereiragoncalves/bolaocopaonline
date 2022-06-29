package com.bolaocopaonline.bolaocopaonline.integration.data.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.BolaoRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import com.bolaocopaonline.bolaocopaonline.integration.data.service.BolaoService
import org.springframework.stereotype.Service
import java.util.*

@Service
class BolaoServiceImpl(private val repository: BolaoRepository) : BolaoService {

    override fun create(bolao: Bolao): Bolao {
        return repository.save(bolao)
    }

    override fun getAll(): List<Bolao> {
        return repository.findAll()
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