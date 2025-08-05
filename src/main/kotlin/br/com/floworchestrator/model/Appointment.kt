package br.com.floworchestrator.model

data class Appointment(
        val id: Long,
        val patientName: String,
        val dateTime: String,
        val description: String
)
