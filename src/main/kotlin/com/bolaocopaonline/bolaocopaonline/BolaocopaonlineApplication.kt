package com.bolaocopaonline.bolaocopaonline

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class BolaocopaonlineApplication

fun main(args: Array<String>) {
	runApplication<BolaocopaonlineApplication>(*args)
}
