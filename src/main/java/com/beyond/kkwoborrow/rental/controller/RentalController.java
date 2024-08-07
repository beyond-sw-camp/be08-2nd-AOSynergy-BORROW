package com.beyond.kkwoborrow.rental.controller;

import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;
import com.beyond.kkwoborrow.rental.service.RentalService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rental-service")
@Tag(name = "Rental APIs", description = "렌탈 관련 API 목록")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping("/{postId}")
    @Operation(summary = "대여 신청", description = "대여 가능한 물품의 목록을 조회한다.")
    public ResponseEntity<RentalResponseDto> Rent(
            @PathVariable("postId") Long postId) {
        RentalResponseDto rentalResponseDto = rentalService.Rent(postId);

        if (rentalResponseDto != null && rentalResponseDto.getPostId() != null) {
            return new ResponseEntity<>(rentalResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/return/{transactionID}")
    @Operation(summary = "반납 신청", description = "반납해야할 물품 목록을 조회한다.")
    public ResponseEntity<RentalResponseDto> Return(
            @PathVariable("transactionID") Long transactionID) {
        RentalResponseDto ReturnSearch = rentalService.Return(transactionID);

        if (ReturnSearch != null) {
            return new ResponseEntity<>(ReturnSearch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

