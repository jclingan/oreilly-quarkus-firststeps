package org.acme;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class WiremockGreetingService
        implements QuarkusTestResourceLifecycleManager {                   // (1)

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer(options().dynamicPort());      // (2)
        wireMockServer.start();                                            // (3)

        wireMockServer.stubFor(get(urlEqualTo("/greeting"))                // (4)
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")                  // (5)
                        .withBody("hello")));                                      // (6)

        wireMockServer.stubFor(get(urlEqualTo("/greeting/list"))           // (7)
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")              // (8)
                        .withBody("[\"Howdy from app.prop\"," +
                                "\"Hola from app.prop\"," +
                                "\"Hello from app.prop\"]")));

        wireMockServer.stubFor(get(urlEqualTo("/greeting/list/random"))    // (9)
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Howdy from app.prop")));

        return Collections
                .singletonMap("org.acme.GreetingsRestClient/mp-rest/url",      // (10)
                        wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (null != wireMockServer) {
            wireMockServer.stop();                                     // (11)
        }
    }
}

