package org.acme;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/logging")
public class LoggingResource {
    private static final
    Logger LOG = Logger.getLogger(LoggingResource.class);                   // (1)


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getLogging() {                                            // (2)
        logginglevels();
        return "Check log output";
    }

    void logginglevels() {
        System.out.println("----------------------------------------");
        LOG.fatal("***** " + LOG.getClass().getSimpleName() + ": FATAL *****");//(3)
        LOG.error("***** " + LOG.getClass().getSimpleName() + ": ERROR *****");
        LOG.warn("***** " + LOG.getClass().getSimpleName() + ": WARN *****");
        LOG.info("***** " + LOG.getClass().getSimpleName() + ": INFO *****");
        LOG.debug("***** " + LOG.getClass().getSimpleName() + ": DEBUG *****");
        LOG.trace("***** " + LOG.getClass().getSimpleName() + ": TRACE *****");
    }
}
