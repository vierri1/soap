package ru.innopolis.stc13.soap;

import io.spring.guides.gs_producing_web_service.Request;
import io.spring.guides.gs_producing_web_service.Response;
import io.spring.guides.gs_producing_web_service.Status;
import io.spring.guides.gs_producing_web_service.StopListItem;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class RequestEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "request")
	@ResponsePayload
	public Response getCountry(@RequestPayload Request request) {
		Response response = new Response();

		if (request == null) {
			response = new Response();
			response.setStatus(Status.OK);
			return response;
		}
		else if ("Греф Герман Оскарович".equals(request.getFio())) {
			StopListItem item = new StopListItem();
			item.setId("01-1");
			item.setDate("23.12.2018");
			item.setPeriod("370");
			List<StopListItem> listItems = new ArrayList<>();
			listItems.add(item);
			response.setStatus(Status.MAYBE);
			response.getStopList().addAll(listItems);
			return response;
		}
		response.setStatus(Status.OK);
		return response;
	}
}