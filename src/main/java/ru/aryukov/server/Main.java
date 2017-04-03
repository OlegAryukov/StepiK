package ru.aryukov.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.aryukov.handler.Frontend;
import ru.aryukov.servlet.AllRequestsServlet;

/**
 * Created by olega on 03.04.17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
