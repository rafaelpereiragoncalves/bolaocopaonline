package com.bolaocopaonline.bolaocopaonline

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.client.RestTemplate

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@Configuration
class BolaocopaonlineApplication{

	@Bean
	fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()

	@Bean
	fun httpHeaders(): HttpHeaders = HttpHeaders()
}

fun main(args: Array<String>) {
	runApplication<BolaocopaonlineApplication>(*args)
}
