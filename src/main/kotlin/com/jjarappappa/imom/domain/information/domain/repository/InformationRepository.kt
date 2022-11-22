package com.jjarappappa.imom.domain.information.domain.repository

import com.jjarappappa.imom.domain.information.Information
import org.springframework.data.jpa.repository.JpaRepository

interface InformationRepository: JpaRepository<Information, Long> {
}