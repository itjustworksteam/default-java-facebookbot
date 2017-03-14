package it.itjustworks.yourserver.server;

public class Configs {
	
	public static int port() {
		return (System.getenv("PORT") != null) ? Integer.parseInt(System.getenv("PORT")) : 8080;
	}
	
	public static String verifyToken() {
		return (System.getenv("VERIFY_TOKEN") != null) ? System.getenv("VERIFY_TOKEN") : "verify_token";
	}
	
	public static String botToken(){
		return (System.getenv("BOT_TOKEN") != null) ? System.getenv("BOT_TOKEN") : "bot_token";
	}

}
