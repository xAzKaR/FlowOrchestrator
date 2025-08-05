package br.com.floworchestrator.service

import br.com.floworchestrator.model.Appointment
import org.springframework.stereotype.Service

@Service
class AppointmentService {

    private val appointments = mutableListOf<Appointment>()
    private var nextId = 1L

    fun createAppointment(patientName: String, dateTime: String, description: String): Appointment {
        val appointment = Appointment(nextId++, patientName, dateTime, description)
        appointments.add(appointment)
        return appointment
    }

    fun listAppointments(): List<Appointment> = appointments
}