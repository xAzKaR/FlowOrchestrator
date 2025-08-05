package br.com.floworchestrator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FloworchestratorApplication

fun main(args: Array<String>) {
	runApplication<FloworchestratorApplication>(*args)
}
