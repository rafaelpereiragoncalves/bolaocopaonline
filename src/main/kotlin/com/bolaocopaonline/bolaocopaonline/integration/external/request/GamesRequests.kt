package com.bolaocopaonline.bolaocopaonline.integration.external.request

data class GamesRequests(
    val response: Collection<Response>
)

data class Response(
    val league: League
)

data class League(
    val id: Int,
    val name: String,
    val standings: Collection<Standing>
)

data class Standing(
    val team: Teamapi,
    val points: Int,
    val group: String
)

data class Teamapi(
    val id: Int,
    val name: String,
    //val logo: Byte
)