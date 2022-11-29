package com.jjarappappa.imom.domain.information.facade

import com.jjarappappa.imom.domain.information.domain.Information
import com.jjarappappa.imom.domain.information.domain.repository.InformationRepository
import com.jjarappappa.imom.domain.information.exception.InformationNotFoundException
import org.springframework.stereotype.Component

@Component
class InformationFacade(
    private val informationRepository: InformationRepository,
) {

    fun findInformationById(id: Long): Information {
        return informationRepository.findInformationById(id)
            ?: throw InformationNotFoundException.EXCEPTION
    }
}