package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/greeting")
public class GreetingResource {
    @ConfigProperty(name="greetings")             // (1)
    List<String> greetings = new ArrayList<>(); // (1)

    UnusedConfigProperties unused;

    public GreetingResource(UnusedConfigProperties unused) {  // (1)
        this.unused = unused;
    }

    @GET
    @Path("/unused")
    @Produces(MediaType.APPLICATION_JSON)
    public UnusedConfigProperties getProps() {                // (2)
        return unused;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listGreetings() {
        return greetings;
    }

    @GET
    @Path("/list/random")
    @Produces(MediaType.TEXT_PLAIN)
    public String randomGreeting() {
        Random r = new Random();
        return greetings.get(r.nextInt(listGreetings().size())); // (1)
    }
}