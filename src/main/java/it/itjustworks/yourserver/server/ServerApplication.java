package it.itjustworks.yourserver.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ServerApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		router.attach("/", IndexResource.class);
		getLogger().info("Started " + IndexResource.class.toString() + " @ /");
				
		router.attach("/path", PathResource.class);
		getLogger().info("Started " + PathResource.class.toString() + " @ /path");
						
		return router;
	}
	
}
