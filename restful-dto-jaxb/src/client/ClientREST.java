package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import service.MessageDTO;

public class ClientREST {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget cible = client.target(UriBuilder.fromPath("http://172.17.0.3:8080/restfuldto"));
		WebTarget ciblefinale = cible.path("dto");
		String var1 = "lecoz";
		String var2 = "invite2016";
		MessageDTO dto = ciblefinale.queryParam("login", var1).queryParam("password", var2)
				.request(MediaType.APPLICATION_XML).get(MessageDTO.class);
		System.out.println(dto.getBienvenue()+" "+dto.getRole());
	}

}