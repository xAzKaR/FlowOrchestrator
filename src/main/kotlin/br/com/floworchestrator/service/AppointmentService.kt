package br.com.floworchestrator.service

import br.com.floworchestrator.model.Appointment
import br.com.floworchestrator.repository.AppointmentRepository
import org.springframework.stereotype.Service

@Service
class AppointmentService(private val repository: AppointmentRepository) {

    fun createAppointment(patientName: String, dateTime: String, description: String): Appointment {
        val appointment = Appointment(id = 0, patientName, dateTime, description)
        return repository.save(appointment)
    }

    fun listAppointments(): List<Appointment> = repository.findAll()
}