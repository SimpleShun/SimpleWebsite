package webserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

//request handlers
import webserver.handlers.*;

public class App {
    public static void main(String[] args) {
       new App();      
    }
    App(){
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(420),0);

            //creating the end points or context 
            HttpContext root = server.createContext("/",new IndexHandler());
            HttpContext nameRoot = server.createContext("/css",new CssHandler());
            HttpContext about = server.createContext("/about",new AboutHandler());
            HttpContext draw = server.createContext("/draw", new DrawHandler());
            HttpContext goal = server.createContext("/goal", new GoalHandler());
            HttpContext grill = server.createContext("/grill", new HandleGrill());
            HttpContext song = server.createContext("/song", new HandleSong());

            server.setExecutor(null);

            System.out.println("Listening to localhost port 420....");
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
