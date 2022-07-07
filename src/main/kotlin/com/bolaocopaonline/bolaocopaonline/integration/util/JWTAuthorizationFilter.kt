package com.bolaocopaonline.bolaocopaonline.integration.util

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import com.bolaocopaonline.bolaocopaonline.integration.data.models.impl.UserDetailImpl
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter(
    authenticationManager: AuthenticationManager,
    private val jwtUtils: JWTUtils,
    private val userRepository: UserRepository
): BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val auth = request.getHeader(authorization)

        if(auth != null && auth.startsWith(bearer)){
            val authorized = getAuthentication(auth)
            SecurityContextHolder.getContext().authentication = authorized
        }

        chain.doFilter(request, response)
    }

    private fun getAuthentication(authorization: String): UsernamePasswordAuthenticationToken {
        val token = authorization.substring(7)
        if(jwtUtils.isTokenValid(token)) {
            val id = jwtUtils.getUsuarioId(token)
            if(id.isNullOrBlank() && !id.isNullOrEmpty()){
                val user = userRepository.findByIdOrNull(id.toLong()) ?: throw UsernameNotFoundException("Usuário não encontrado!")
                val userImpl = UserDetailImpl(user)
                return UsernamePasswordAuthenticationToken(userImpl, null, userImpl.authorities)
            }
        }

        throw UsernameNotFoundException("Token não é valido.")
    }
}