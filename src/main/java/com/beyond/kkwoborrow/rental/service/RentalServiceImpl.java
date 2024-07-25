package com.beyond.kkwoborrow.rental.service;

import com.beyond.kkwoborrow.rental.entity.Rental;
import com.beyond.kkwoborrow.rental.dto.RentalResponseDto;
import com.beyond.kkwoborrow.rental.repository.RentalRepository;

import java.time.LocalDateTime;
import java.util.List;


public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;

    @Override
    public List<Rental> findAll() {

        return rentalRepository.findAll();
    }

    @Override
    public RentalResponseDto Return(LocalDateTime returnDate) {

        return null;
    }

}