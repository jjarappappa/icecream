package com.jjarappappa.imom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ImomApplication

fun main(args: Array<String>) {
	runApplication<ImomApplication>(*args)
}
