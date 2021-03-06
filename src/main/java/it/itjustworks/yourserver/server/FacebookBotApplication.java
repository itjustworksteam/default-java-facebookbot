package it.itjustworks.yourserver.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class FacebookBotApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		router.attach("/facebookbot", FacebookBotResource.class);
		getLogger().info("Started " + FacebookBotResource.class.toString() + " @ /facebookbot");
		
		return router;
	}
	
}
