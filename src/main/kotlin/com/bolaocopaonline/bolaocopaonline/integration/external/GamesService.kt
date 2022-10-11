package com.bolaocopaonline.bolaocopaonline.integration.external

import com.bolaocopaonline.bolaocopaonline.integration.external.request.GamesRequests
import com.bolaocopaonline.bolaocopaonline.integration.external.request.Response
import org.springframework.http.ResponseEntity

interface GamesService {

    fun getGames() : Collection<Response>
}