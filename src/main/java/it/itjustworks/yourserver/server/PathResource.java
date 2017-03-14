package it.itjustworks.yourserver.server;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class PathResource extends ServerResource{
		
	@Post
	public String postHello(Representation data) throws IOException {
		String request = data.getText();		
		getLogger().info(request);
		return request;
	}
	
	@Get
	public String getHello(){
		return "HELLO PATH!!!";
	}
	
}
