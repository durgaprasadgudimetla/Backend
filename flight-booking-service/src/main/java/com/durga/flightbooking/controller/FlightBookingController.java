package com.durga.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.durga.flightbooking.dto.FlightBookingAckowledgement;
import com.durga.flightbooking.dto.FlightBookingRequestDto;
import com.durga.flightbooking.model.mysql.EmpDetails;
import com.durga.flightbooking.service.FlightBookingService;

@RestController
@RequestMapping(value = "/flightbooking")
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping(value = "/bookFlightTicket")
	public FlightBookingAckowledgement bookFlightTicket(@RequestBody FlightBookingRequestDto flightBookingRequest) {
		return flightBookingService.bookFlightTicket(flightBookingRequest);

	}

	@PostMapping(value = "/savePayement")
	public FlightBookingAckowledgement savePayement(@RequestBody FlightBookingRequestDto flightBookingRequest) {
		return flightBookingService.savePayement(flightBookingRequest);

	}

	@RequestMapping(value = "/getEmployeeDetils", method = RequestMethod.GET)
	public List<EmpDetails> getEmployeeDetils() {
		return flightBookingService.getEmployeeDetils();
	}

}
