package org.acme;


import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/training")
public class TrainingResource {              // (1)
    @Inject
    TrainingRepository repository;                               // (1)

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/repository")
    public Training postRepositoryTraining(Training training) {
        repository.persist(training);                            // (2)

        return training;
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> listTrainings() {
        return Training.listAll();                       // (2)
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Training postTraining(Training training) {
        training.persist();                              // (3)

        return training;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/repository/{name}")
    public Training getRepositoryTraining(@PathParam("name") String name) {
        return repository.findByName(name);
    }

}