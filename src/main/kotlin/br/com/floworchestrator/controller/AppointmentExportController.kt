package br.com.floworchestrator.controller

import br.com.floworchestrator.service.AppointmentExportService
import br.com.floworchestrator.service.AppointmentService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/appointments")
class AppointmentExportController (private val exportService: AppointmentExportService) {
    @GetMapping("/export")
    fun exportCsv(): ResponseEntity<String> {
        val csv = exportService.exportCsv()
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=consultas.csv")
                .contentType(MediaType.TEXT_PLAIN)
                .body(csv)
    }
}