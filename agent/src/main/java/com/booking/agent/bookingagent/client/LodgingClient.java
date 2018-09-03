package com.booking.agent.bookingagent.client;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.booking.agent.bookingagent.model.GetAllRequest;
import com.booking.agent.bookingagent.model.GetAllResponse;
import com.booking.agent.bookingagent.model.GetLodgingRequest;
import com.booking.agent.bookingagent.model.GetLodgingResponse;
import com.booking.agent.bookingagent.model.Lodging;
import com.booking.agent.bookingagent.model.Message;
import com.booking.agent.bookingagent.model.Period;
import com.booking.agent.bookingagent.model.Reservations;
import com.booking.agent.bookingagent.model.SenMessageRequest;
import com.booking.agent.bookingagent.model.SetPeriodRequest;
import com.booking.agent.bookingagent.model.SetReservation;



public class LodgingClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(LodgingClient.class);

	public GetLodgingResponse getLodging(String ticker) {

		GetLodgingRequest request = new GetLodgingRequest();
		Lodging lodg =new Lodging();
		lodg.setId(1L);
		
		request.setLodging(lodg);

		log.info("Requesting Lodging for " + ticker);

		GetLodgingResponse response = (GetLodgingResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/getLodgingRequest"));

		return response;
	}

	public GetLodgingResponse saveLodging(Lodging lodging) {
		System.out.println("POGODI SAVE");
		GetLodgingRequest  request = new GetLodgingRequest();
		request.setLodging(lodging);
		GetLodgingResponse response = (GetLodgingResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/saveLodging"));

		return response;
	}
	public void updatePeriod(Period period, String string){
		System.out.println("POGODI UPDATE");
		SetPeriodRequest  request = new SetPeriodRequest();
		request.setPeriod(period);
		request.setLodgingName(string);
		 getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/updatePeriod"));

	}

	public void updateReservation(Reservations reservation, String name) {
		System.out.println("POGODI UPDATE");
		SetReservation  request = new SetReservation();
		request.setReservation(reservation);
		request.setLodgingName(name);
		 getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/updateReservation"));

		
	}

	public GetAllResponse getAll(String agentId) {
		GetAllRequest request = new GetAllRequest();
		request.setAgentId(agentId);
		GetAllResponse response = (GetAllResponse)getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/getAll"));

		return response;
		
	}

	public void sendMessage(Message message) {
		SenMessageRequest request = new SenMessageRequest();
		request.setMessage(message);
		getWebServiceTemplate()
		.marshalSendAndReceive("http://localhost:8080/ws",
				request,
				new SoapActionCallback("http://localhost:8080/ws/sendMessage"));

		
	}
}