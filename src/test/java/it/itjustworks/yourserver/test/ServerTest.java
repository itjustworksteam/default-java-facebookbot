package it.itjustworks.yourserver.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;

import it.itjustworks.yourserver.server.Configs;
import it.itjustworks.yourserver.server.Server;

public class ServerTest {

	static Server server;
	
	@BeforeClass
	public static void setUp() throws Exception {
		server = new Server();
		server.start();
	}
			
	@Test
	public void testOne() throws IOException {
		ClientResource client = new ClientResource("http://localhost:" + Configs.port() + "/facebookbot?hub.mode=mode&hub.challenge=challenge&hub.verify_token=verify_token");
		Representation data = client.get();
		assertEquals("challenge", data.getText());
	}
	
	@Test
	public void testTwo() throws IOException {
		ClientResource client = new ClientResource("http://localhost:" + Configs.port() + "/facebookbot");
		Representation data = client.post(createMessage());
		assertNull(data.getText());
	}
	
	@Test
	public void testThree() throws IOException {
		ClientResource client = new ClientResource("http://localhost:" + Configs.port() + "/facebookbot?hub.mode=mode&hub.challenge=challenge&hub.verify_token=token");
		Representation data = client.get();
		assertNull(data.getText());
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		server.stop();
	}
	
	private StringRepresentation createMessage() {
		StringRepresentation str = new StringRepresentation(request());
		return str;
	}
	
	private String request() {
		return "{\"object\":\"page\","
				+ "\"entry\":[{\"id\":\"PAGE_ID\",\"time\":1458692752478,"
				+ "\"messaging\":[{\"sender\":{\"id\":\"USER_ID\"},\"recipient\":{\"id\":\"PAGE_ID\"},\"timestamp\":1458692752478,"
				+ "\"message\":{\"mid\":\"mid.1457764197618:41d102a3e1ae206a38\",\"seq\":73,\"text\":\"hello, world!\","
				+ "\"quick_reply\": {\"payload\": \"DEVELOPER_DEFINED_PAYLOAD\"}}}]}]}";
	}
		
}
