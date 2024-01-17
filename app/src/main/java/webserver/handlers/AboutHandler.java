package webserver.handlers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AboutHandler implements HttpHandler{
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
            } else{
                t.sendResponseHeaders(404,0);
                os.write(new String("<b>Can't touch This !!</b>").getBytes());
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

