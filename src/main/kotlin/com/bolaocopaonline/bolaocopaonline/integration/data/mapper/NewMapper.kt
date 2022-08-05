package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

interface NewMapper <D, E> {

    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E

}