package br.com.floworchestrator.controller

import br.com.floworchestrator.dto.CreateAppointmentRequest
import br.com.floworchestrator.model.Appointment
import br.com.floworchestrator.service.AppointmentService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appointments")
class AppointmentController(private val service: AppointmentService) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateAppointmentRequest): Appointment {
        return service.createAppointment(request.patientName, request.dateTime, request.description)
    }

    @GetMapping
    fun list(@RequestParam(required = false) patientName: String?): List<Appointment> {
        return service.listAppointments(patientName)
    }
}