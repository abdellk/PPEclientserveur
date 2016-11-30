package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("dto")
public class ServiceREST {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public MessageDTO getDTO(@QueryParam("login") String login, @QueryParam("password") String password) {
		
		MessageDTO message = new MessageDTO("Bienvenue "+login, "administrateur");
		return message;		
	}
}