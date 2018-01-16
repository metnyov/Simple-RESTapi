package com.wkwn.rest.notes;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;


public class Main {
    public static final String BASE_URI = "http://localhost:8080/";

    public static HttpServer createServer() {
        final ResourceConfig rc = new ResourceConfig();
        rc.packages(true, "com.wkwn.rest.notes");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc, false);
        server.getServerConfiguration().setAllowPayloadForUndefinedHttpMethods(true); // +DELETE
        return server;
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = createServer();
        server.start();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

