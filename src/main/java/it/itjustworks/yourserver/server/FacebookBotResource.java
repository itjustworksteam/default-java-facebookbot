package it.itjustworks.yourserver.server;

import java.io.IOException;
import java.util.Map;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import it.therickys93.facebookbot.Hub;
import it.therickys93.facebookbot.model.FacebookBotParser;
import it.therickys93.facebookbot.model.Payload;

public class FacebookBotResource extends ServerResource {

	@Get
	public String acceptChallenge() throws IOException {
		Map<String, String> challenge = getQuery().getValuesMap();
		Hub hub = new Hub(challenge, Configs.verifyToken());
		if(hub.ok()){
			return hub.challenge();
		} else {
			getLogger().warning(Hub.TOKEN_ERROR);
			return null;
		}
	}
	
	@Post
	public Representation payload(Representation data) throws IOException {
		String newMessage = data.getText();
		Payload payload = FacebookBotParser.parsePayload(newMessage);
		String chatId = payload.entry().messaging().senderId();
		String text = payload.entry().messaging().message().text();
		getLogger().info(chatId + " --> " + text);
		/*
		 * uncomment the code below to send the message
		FacebookBot bot = new FacebookBot(Configs.botToken());
		String response = bot.execute(new SendMessage(chatId, text));
		getLogger().info(response);
		*/
		return null;
	}
	
}
