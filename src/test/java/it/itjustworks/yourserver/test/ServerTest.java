package it.itjustworks.yourserver.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.representation.Representation;
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
		ClientResource client = new ClientResource("http://localhost:" + Configs.port());
		Representation data = client.get();
		assertEquals(indexResponse(), data.getText());
	}
	
	@Test
	public void testTwo() throws IOException {
		ClientResource client = new ClientResource("http://localhost:" + Configs.port() + "/path");
		Representation data = client.get();
		assertEquals("HELLO PATH!!!", data.getText());
	}
	
	@Test
	public void testThree() throws IOException {
		ClientResource client = new ClientResource("http://localhost:" + Configs.port() + "/path");
		Representation data = client.post("ciao");
		assertEquals("ciao", data.getText());
	}
		
	@AfterClass
	public static void tearDown() throws Exception {
		server.stop();
	}
	
	private String indexResponse() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/main/resources/index.html"));
		String htmlFile = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return htmlFile;
	}
	
}
