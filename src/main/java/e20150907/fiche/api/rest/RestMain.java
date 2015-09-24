package e20150907.fiche.api.rest;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import e20150907.fiche.util.UrlUtil;

import java.io.IOException;

/**
 * Created by Tom on 22-9-2015.
 */
public class RestMain {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create(UrlUtil.host);
        server.start();

        System.out.println("Server running");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
