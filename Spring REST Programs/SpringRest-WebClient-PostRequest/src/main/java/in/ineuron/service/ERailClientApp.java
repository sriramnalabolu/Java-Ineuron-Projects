package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@Service("service")
public class ERailClientApp {

	private static final String REST_END_URL = "http://localhost:8888/api/ticket/register";
	
	public void invokeRestApi() {

		WebClient client = WebClient.create();

		PassengerInfo body = new PassengerInfo();
		body.setFirstName("nitin");
		body.setLastName("manjunath");
		body.setJourneyDate("22/06/2023");
		body.setFrom("bengaluru");
		body.setTo("pune");
		body.setTrainNumber("BNG-PUN-1234");

		Ticket response = client.post().uri(REST_END_URL).accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(body)).retrieve().bodyToMono(Ticket.class).block();

		System.out.println(response);

	}
	
	public void invokeRestApiASync() {

	    // Sending Asynchronous request
	    WebClient webClient = WebClient.create();
	    System.out.println("****ASynchronous: Restcall started ******");
	    
		PassengerInfo body = new PassengerInfo();
		body.setFirstName("nitin");
		body.setLastName("manjunath");
		body.setJourneyDate("22/06/2023");
		body.setFrom("bengaluru");
		body.setTo("pune");
		body.setTrainNumber("BNG-PUN-1234");

		webClient
			.post()
			.uri(REST_END_URL)
			.accept(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(body))
			.retrieve().bodyToMono(Ticket.class)
			.subscribe(ERailClientApp::myResponse);

	    System.out.println("****ASynchronous: Restcall ended ******");
	}

	public static void myResponse(Ticket response) {
	    System.out.println(response);
	    // use response object as per the needs [push to Apache-kafka]
	}

}

