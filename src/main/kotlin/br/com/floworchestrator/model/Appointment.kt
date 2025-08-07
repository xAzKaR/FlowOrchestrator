package br.com.floworchestrator.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Appointment @JvmOverloads constructor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(nullable = false)
        val patientName: String,
        @Column(nullable = false)
        val dateTime: String,
        @Column(nullable = false)
        val description: String
)
{
        protected constructor() : this(0, "", "", "")
}