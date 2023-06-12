package com.zerobase.css.controller

import com.zerobase.css.dto.LoanRequestDto
import com.zerobase.css.dto.LoanResultDto
import com.zerobase.css.service.LoanReviewService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/css/api/v1")
class LoanReceiveController(
    private val loanReviewService: LoanReviewService
) {
    @ApiOperation("대출 심사 api")
    @PostMapping("/request")
    fun loanReceive(
        @RequestBody requestInputDto: LoanRequestDto.RequestInputDto
    ): LoanResultDto.ResponseDto =
        loanReviewService.loanReview(requestInputDto)
}