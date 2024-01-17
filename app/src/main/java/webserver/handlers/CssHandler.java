package webserver.handlers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//handles call to /css
public class CssHandler implements HttpHandler{
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

