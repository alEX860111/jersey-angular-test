package ngdemo.rest;

import java.net.URI;
import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

import com.google.inject.servlet.GuiceFilter;

final class TestServer {

    private static final int PORT = 8080;

    private static final String PATH = "/api/*";

    private Server server;

    public void start() throws Exception {
        server = new Server(PORT);

        WebAppContext context = new WebAppContext();
        context.setServer(server);

        context.addFilter(GuiceFilter.class, PATH, EnumSet.allOf(DispatcherType.class));

        ServletHolder holder = context.addServlet(ServletContainer.class, PATH);
        holder.setInitParameter("javax.ws.rs.Application", "ngdemo.app.Application");

        context.addServlet(holder, PATH);

        context.setContextPath("/");
        context.setWar("src/main/webapp");

        server.setHandler(context);

        server.start();
    }

    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            System.out.println("Failed to stop server.");
            e.printStackTrace();
        }
    }

    public URI getBaseUri() {
        return server.getURI();
    }

}