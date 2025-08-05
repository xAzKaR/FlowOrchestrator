package br.com.floworchestrator.controller

import br.com.floworchestrator.model.Appointment
import br.com.floworchestrator.service.AppointmentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appointments")
class AppointmentController (private val service: AppointmentService) {

    data class CreateAppointmentRequest(
            val patientName: String,
            val dateTime: String,
            val description: String
    )

    @PostMapping
    fun create(@RequestBody request: CreateAppointmentRequest): Appointment {
        return service.createAppointment(request.patientName, request.dateTime, request.description)
    }

    @GetMapping
    fun list(): List<Appointment> = service.listAppointments()
}