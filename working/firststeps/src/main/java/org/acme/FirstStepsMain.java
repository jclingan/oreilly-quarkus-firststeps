package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;

@QuarkusMain                                                     // (1)
public class FirstStepsMain implements QuarkusApplication {      // (2)
    @Inject
    @RestClient                                             // (1)
    GreetingsRestClient client;

    @Override
    public int run(String... args) throws Exception {            // (3)
        System.out.println("******* " + args[0]                  // (4)
                + " " + args[1]
                + " ********");
        System.out.println(client.listGreetings());
        Quarkus.waitForExit();                          // (1)
        return 0;                                                // (5)
    }

    public static void main(String... args ) {
        Quarkus.run(FirstStepsMain.class, args);  // (1)
    }
}

