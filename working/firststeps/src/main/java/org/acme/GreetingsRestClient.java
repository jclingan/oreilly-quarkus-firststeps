package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/greeting")
@RegisterRestClient(baseUri = "http://localhost:8080")
public interface GreetingsRestClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listGreetings();

    @GET
    @Path("/list/random")
    @Produces(MediaType.TEXT_PLAIN)
    public String randomGreeting();
}

