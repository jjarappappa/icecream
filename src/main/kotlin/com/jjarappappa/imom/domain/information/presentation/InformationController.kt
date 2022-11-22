package com.jjarappappa.imom.domain.information.presentation

import com.jjarappappa.imom.domain.information.presentation.dto.FindInformationRequest
import com.jjarappappa.imom.domain.information.presentation.dto.InformationResponse
import com.jjarappappa.imom.domain.information.presentation.dto.request.CreateInformationRequest
import com.jjarappappa.imom.domain.information.service.InformationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/information")
class InformationController(
    private val informationService: InformationService,
) {

    @PostMapping
    fun createInformation(@RequestBody @Valid request: CreateInformationRequest) {
        informationService.createInformation(request)
    }

    @GetMapping
    fun findInformation(@RequestBody @Valid request: FindInformationRequest): List<InformationResponse> {
        return informationService.findInformation(request)
    }
}