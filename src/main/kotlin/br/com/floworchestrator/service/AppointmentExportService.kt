package br.com.floworchestrator.service

import br.com.floworchestrator.repository.AppointmentRepository
import org.springframework.stereotype.Service
import java.io.PrintWriter
import java.io.StringWriter

@Service
class AppointmentExportService (private val repository: AppointmentRepository) {

    fun exportCsv(): String {
        val writer = StringWriter()
        val csvWriter = PrintWriter(writer)

        // Header
        csvWriter.println("ID,Patient Name,Date Time,Description")

        // Body
        repository.findAll().forEach {
            csvWriter.println("\"${it.id}\",\"${it.patientName}\",\"${it.dateTime}\",\"${it.description}\"")
        }

        csvWriter.flush()
        return writer.toString()
    }
}