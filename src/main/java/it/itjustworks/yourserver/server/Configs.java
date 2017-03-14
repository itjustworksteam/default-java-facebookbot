package it.itjustworks.yourserver.server;

public class Configs {
	
	public static int port() {
		return Integer.parseInt(System.getenv("PORT"));
	}

}
