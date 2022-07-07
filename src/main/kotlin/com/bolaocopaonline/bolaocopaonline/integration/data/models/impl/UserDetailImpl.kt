package com.bolaocopaonline.bolaocopaonline.integration.data.models.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailImpl(private val user: User) : UserDetails {
    override fun getAuthorities() = mutableListOf<GrantedAuthority>()

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}