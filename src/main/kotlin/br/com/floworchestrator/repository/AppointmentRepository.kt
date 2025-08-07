package br.com.floworchestrator.repository

import br.com.floworchestrator.model.Appointment
import org.springframework.data.jpa.repository.JpaRepository

interface AppointmentRepository : JpaRepository<Appointment, Long>