package com.jjarappappa.imom.domain.information.service

import com.jjarappappa.imom.domain.information.Information
import com.jjarappappa.imom.domain.information.domain.repository.InformationRepository
import com.jjarappappa.imom.domain.information.presentation.dto.FindInformationRequest
import com.jjarappappa.imom.domain.information.presentation.dto.InformationResponse
import com.jjarappappa.imom.domain.information.presentation.dto.request.CreateInformationRequest
import com.jjarappappa.imom.domain.information.presentation.dto.request.toEntity
import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InformationService(
    private val informationRepository: InformationRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun createInformation(request: CreateInformationRequest) {
        val user = userFacade.getCurrentUser()
        val information = request.toEntity(user)
        informationRepository.save(information)
    }

    @Transactional(readOnly = true)
    fun findInformation(request: FindInformationRequest): List<InformationResponse> {
        val category = request.category
        val information = informationRepository.findByCategory(category)
        return information
            .map { InformationResponse.of(it) }
    }
}