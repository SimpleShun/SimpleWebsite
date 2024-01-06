package webserver;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

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

class IndexHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        try {
            URI u = new URI("/");
            OutputStream os = t.getResponseBody();
            if(t.getRequestMethod().equals(new String("GET")) && t.getRequestURI().equals(new URI("/"))){
                Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/index.html");
                try {
                    t.sendResponseHeaders(200,0);
                    Files.copy(path, os);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                t.sendResponseHeaders(404,0);
                os.write(new String("<b>Can't touch This !!</b>").getBytes());
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CssHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/css/style.css");
        OutputStream cs = t.getResponseBody();
        try {
            t.sendResponseHeaders(200,0);
            Files.copy(path, cs);
            cs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class AboutHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        try {
            URI u = new URI("/about");
            if(t.getRequestURI().equals(u)){
                Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/html/swap.html");
                OutputStream os = t.getResponseBody();
                try {
                    t.sendResponseHeaders(200,0);
                    Files.copy(path, os);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DrawHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        try {
            URI u = new URI("/draw");
            if(t.getRequestURI().equals(u)){
                Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/html/swap.html");
                OutputStream os = t.getResponseBody();
                try {
                    t.sendResponseHeaders(200,0);
                    Files.copy(path, os);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class GoalHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        try {
            URI u = new URI("/goal");
            if(t.getRequestURI().equals(u)){
                Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/html/swap.html");
                OutputStream os = t.getResponseBody();
                try {
                    t.sendResponseHeaders(200,0);
                    Files.copy(path, os);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HandleGrill implements HttpHandler{
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        try {
            t.sendResponseHeaders(200, 0);
            OutputStream os = t.getResponseBody();
            Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/th-174333482.jpg");
            Files.copy(path, os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HandleSong implements HttpHandler{
    public void handle(HttpExchange t){
        System.out.println("issued to "+ t.getRequestURI());
        try {
            t.sendResponseHeaders(200, 0);
            OutputStream os = t.getResponseBody();
            Path path = Path.of("/home/simpleshun/java/webserver/app/src/main/resources/mywebsite/mayaSad.mp3");
            Files.copy(path, os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
