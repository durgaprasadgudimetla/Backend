package com.durga.flightbooking.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durga.flightbooking.model.postgres.PassengerInfo;

@Repository
public interface PassangerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
