package com.bolaocopaonline.bolaocopaonline.integration.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

class JWTUtils {
    private val securityKey = "95ce1fdc-e077-4873-bf6e-42a0411a4845"

    fun tokenGenerate(id: String) : String {
        return Jwts.builder()
            .setSubject(id)
            .signWith(SignatureAlgorithm.ES512, securityKey.toByteArray())
            .compact()
    }

    fun isTokenValid(token: String): Boolean{
        val claims = getClaimsToken(token)

        if(claims != null){
            val id = claims.subject
            if(id.isNullOrBlank() && !id.isNullOrEmpty()){
                return true
            }
        }
        return false
    }

    private fun getClaimsToken(token: String): Claims? {
        return try {
            Jwts.parser().setSigningKey(securityKey.toByteArray()).parseClaimsJws(token).body
        } catch (exception: Exception) {
            null
        }
    }

    fun getUsuarioId(token: String) : String?{
        val claims = getClaimsToken(token)
        return claims?.subject
    }
}