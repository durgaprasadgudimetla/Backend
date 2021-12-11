package com.durga.flightbooking.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.durga.flightbooking.dto.FlightBookingAckowledgement;
import com.durga.flightbooking.dto.FlightBookingRequestDto;
import com.durga.flightbooking.employee.repository.EmployeeRepository;
import com.durga.flightbooking.flight.repository.PassangerInfoRepository;
import com.durga.flightbooking.model.mysql.EmpDetails;
import com.durga.flightbooking.model.postgres.PassengerInfo;
import com.durga.flightbooking.model.postgres.PaymentInfo;

@Service
public class FlightBookingService {
	
	@Autowired(required = true)
	private PassangerInfoRepository passengerInfoRepo;
	//@Autowired
	//private PaymentInfoRepository paymentInfoRepo;
	PassengerInfo paasengerInfo = null;	
	
	@Autowired
	private EmployeeRepository employeeRespository;
	
	@Transactional//(isolation = Isolation.READ_UNCOMMITTED)
	public FlightBookingAckowledgement bookFlightTicket(FlightBookingRequestDto flightBookingRequest) {
		 paasengerInfo = flightBookingRequest.getPassengerInfo();
		 
		 List<PassengerInfo> passengerInfoList =  passengerInfoRepo.findAll();
		 
		 System.out.println("passengerInfoList0::"+ passengerInfoList.size());
		 PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
			
			paymentInfo.setPassangerId(paasengerInfo.getpId());
			paymentInfo.setAmount(paasengerInfo.getAmount()); 
			//savePayement(flightBookingRequest);
		/* try {
			TimeUnit.MINUTES.sleep(1);
			//TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		paasengerInfo = passengerInfoRepo.save(paasengerInfo);
		
		List<PassengerInfo> passengerInfoList1 =  passengerInfoRepo.findAll();
		 
		 System.out.println("passengerInfoList1::"+ passengerInfoList1.size());
		
		
		//PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), paymentInfo.getAmount());
		//paymentInfoRepo.save(paymentInfo);
		return new FlightBookingAckowledgement("SUCCESS",paasengerInfo.getAmount(),UUID.randomUUID().toString(),paasengerInfo);
		
	}
	//@Transactional(propagation =  Propagation.REQUIRED)
	public FlightBookingAckowledgement savePayement(FlightBookingRequestDto flightBookingRequest) {
			
			PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
			paasengerInfo = flightBookingRequest.getPassengerInfo();
			paymentInfo.setPassangerId(paasengerInfo.getpId());
			paymentInfo.setAmount(paasengerInfo.getAmount()); 
			paasengerInfo = passengerInfoRepo.save(paasengerInfo);
			//savePayement(paymentInfo);
			//PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), paymentInfo.getAmount());
			//paymentInfoRepo.save(paymentInfo);
			return new FlightBookingAckowledgement("SUCCESS",paasengerInfo.getAmount(),UUID.randomUUID().toString(),paasengerInfo);
		 
	}
	@PostConstruct
	public void saveDataToDB() {
		employeeRespository.saveAll(Stream.of(new EmpDetails("durgaprasad","gudimetla","prasad.javadp@gmail.com",9790750438l,"hyd","yadavolu",358),new EmpDetails("sanjeev","makkena","sanjeev@gmail.com",89299349234L,"hyd","vijayawada",234)).collect(Collectors.toList()));
	}
	
	public List<EmpDetails> getEmployeeDetils() {
		return employeeRespository.findAll();
	}

}
