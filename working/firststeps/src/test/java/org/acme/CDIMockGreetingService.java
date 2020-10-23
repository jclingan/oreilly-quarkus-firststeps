package org.acme;

import io.quarkus.test.Mock;
import org.acme.FirstStepsResource;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//@Mock
@ApplicationScoped
public class CDIMockGreetingService extends FirstStepsResource {
    @Override
    public List<String> listGreetings() {
        return Arrays.asList("Howdy from app.prop",
                "Hola from app.prop",
                "Hello from app.prop");
    }

    @Override
    public String getRandom() {
        Random r = new Random();
        List<String> greetings = listGreetings();
        return greetings.get(r.nextInt(listGreetings().size()));
    }
}