package com.zerobase.api.loan.review

import io.swagger.annotations.ApiOperation
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanReviewController(
    private val loanReviewServiceImpl: LoanReviewServiceImpl
) {
    @ApiOperation("유저의 대출 심사 결과 조회")
    @GetMapping("review/{userKey}")
    fun getReviewData(
        @PathVariable userKey: String
    ): ResponseEntity<LoanReviewDto.LoanReviewResponseDto> {
        return ResponseEntity.ok(
            loanReviewServiceImpl.loanReviewMain(userKey)
        )
    }
}