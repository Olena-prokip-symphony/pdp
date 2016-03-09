package com.endpoint;
 
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.ws.Endpoint;

import com.ws.ServerInfo;

public class WsPublisher{
 
	public static void main(String[] args) throws IOException, URISyntaxException {
	   Endpoint.publish("http://localhost:8088/ws/server", new ServerInfo());
	   Desktop.getDesktop().browse(new URI("http://localhost:8088/ws/server"));

	   System.out.println("SUCCESS");
    }
 
}