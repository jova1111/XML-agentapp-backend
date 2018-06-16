package com.booking.agent.bookingagent.client;



import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.booking.agent.bookingagent.model.GetLodgingRequest;
import com.booking.agent.bookingagent.model.GetLodgingResponse;
import com.booking.agent.bookingagent.model.Lodging;



public class LodgingClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(LodgingClient.class);

	public GetLodgingResponse getLodging(String ticker) {

		GetLodgingRequest request = new GetLodgingRequest();
		Lodging lodg =new Lodging();
		lodg.setId(1L);
		lodg.setNaziv("Naziv");
		request.setLodging(lodg);

		log.info("Requesting Lodging for " + ticker);

		GetLodgingResponse response = (GetLodgingResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/getLodgingRequest"));

		return response;
	}

	public GetLodgingResponse saveLodging(Lodging lodging) {
		GetLodgingRequest  request = new GetLodgingRequest();
		request.setLodging(lodging);
		GetLodgingResponse response = (GetLodgingResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws/saveLodging"));

		return response;
	}
}