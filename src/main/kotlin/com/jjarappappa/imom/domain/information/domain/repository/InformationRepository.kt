package com.jjarappappa.imom.domain.information.domain.repository

import com.jjarappappa.imom.domain.information.Category
import com.jjarappappa.imom.domain.information.Information
import org.springframework.data.jpa.repository.JpaRepository

interface InformationRepository: JpaRepository<Information, Long> {
    fun findInformationById(InformationId: Long): Information?
    fun findByCategory(category: Category): List<Information>
}