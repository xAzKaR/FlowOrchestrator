package br.com.floworchestrator.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class CreateAppointmentRequest(
        @field:NotBlank(message = "O nome do paciente é obrigatório.")
        val patientName: String,

        @field:NotBlank(message = "A data e hora são obrigatórias.")
        @field:Pattern(
                regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}$",
                message = "Formato de data/hora inválido. Use o padrão yyyy-MM-ddTHH:mm"
        )
        val dateTime: String,

        @field:NotBlank(message = "A descrição é obrigatória.")
        val description: String
)