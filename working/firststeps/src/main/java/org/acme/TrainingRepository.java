package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingRepository implements PanacheRepository<Training> {
    public Training findByName(String name) {          // (1)
        return find("name", name).firstResult();       // (2)
    }
}

