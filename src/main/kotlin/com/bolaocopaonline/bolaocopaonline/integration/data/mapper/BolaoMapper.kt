package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import org.springframework.stereotype.Component

@Component
class BolaoMapper: Mapper<Bolao, BolaoDTO> {

    override fun map(t: Bolao): BolaoDTO {
        return BolaoDTO(
            name = t.name,
            guessesToRound = t.guessesToRound,
            approvalToAdmin = t.approvalToAdmin
        )
    }

}