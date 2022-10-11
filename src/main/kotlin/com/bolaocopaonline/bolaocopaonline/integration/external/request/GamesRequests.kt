package com.bolaocopaonline.bolaocopaonline.integration.external.request

data class GamesRequests(
    val response: Collection<Response>
)

data class Response(
    val league: League
)

data class League(
    val id: Int,
    val name: String
)