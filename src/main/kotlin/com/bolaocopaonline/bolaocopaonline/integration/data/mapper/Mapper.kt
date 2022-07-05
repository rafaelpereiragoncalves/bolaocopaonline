package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

interface Mapper<T, U> {

    fun map(t: T) : U
}
