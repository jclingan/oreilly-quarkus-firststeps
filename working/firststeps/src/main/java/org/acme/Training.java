package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Training extends PanacheEntity {                       // (1)
    public String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    public List<Student> students;

    public Training() {
        students = new ArrayList<Student>();
    }

    public Training(String name) {
        this();
        this.name = name;
    }

    public String getName() {         // (1)
        return name + "!";
    }
}

