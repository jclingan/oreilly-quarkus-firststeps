package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Student extends PanacheEntity {   // (1)
    public String name;                        // (2)
}