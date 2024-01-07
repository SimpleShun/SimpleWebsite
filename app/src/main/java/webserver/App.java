package webserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

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
            OutputStream os = t.getResponseBody();
            if(t.getRequestMethod().equals("GET") && t.getRequestURI().equals(new URI("/"))){
                try {
                    InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/index.html");
                    t.sendResponseHeaders(200,0);
                    io.transferTo(os);
                    os.close();
                    io.close();
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

//handles call to /css
class CssHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        OutputStream cs = t.getResponseBody();
        try {
            if (t.getRequestURI().equals(new URI("/css"))) {
                InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/css/style.css");
                t.sendResponseHeaders(200,0);
                io.transferTo(cs);
                cs.close();
                io.close();
            }else{
                t.sendResponseHeaders(404,0);
                cs.write(new String("<b>Can't touch This !!</b>").getBytes());
                cs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class AboutHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        OutputStream os = t.getResponseBody();
        try {
            if(t.getRequestURI().equals(new URI("/about")) && t.getRequestMethod().equals("GET")){
                InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/html/swap.html");
                t.sendResponseHeaders(200,0);
                io.transferTo(os);
                os.close();
                io.close();
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

class DrawHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        OutputStream os = t.getResponseBody();
        try{
            if(t.getRequestURI().equals(new URI("/draw")) && t.getRequestMethod().equals("GET")){
                InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/html/swap.html");
                t.sendResponseHeaders(200,0);
                io.transferTo(os);
                os.close();
                io.close();
            }else{
                t.sendResponseHeaders(404,0);
                os.write(new String("<b>Can't touch This !!</b>").getBytes());
                os.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class GoalHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange t){
        OutputStream os = t.getResponseBody();
        try {
            if(t.getRequestURI().equals(new URI("/goal")) && t.getRequestMethod().equals("GET")){
                InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/html/swap.html");
                t.sendResponseHeaders(200,0);
                io.transferTo(os);
                os.close();
                io.close();
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

class HandleGrill implements HttpHandler{
    public void handle(HttpExchange t){
        OutputStream os = t.getResponseBody();
        try {
            if(t.getRequestMethod().equals("GET") && t.getRequestURI().equals(new URI("/grill"))){
                InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/th-174333482.jpg");
                t.sendResponseHeaders(200,0);
                io.transferTo(os);
                os.close();
                io.close();
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

class HandleSong implements HttpHandler{
    public void handle(HttpExchange t){
        OutputStream os = t.getResponseBody();
        try {
            if(t.getRequestMethod().equals("GET") && t.getRequestURI().equals(new URI("/song"))){
                InputStream io = getClass().getClassLoader().getResourceAsStream("mywebsite/mayaSad.mp3");
                t.sendResponseHeaders(200,0);
                io.transferTo(os);
                os.close();
                io.close();
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
