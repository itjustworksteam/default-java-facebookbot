package it.itjustworks.yourserver.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import it.itjustworks.yourserver.server.Configs;

public class ImproveCodeCoverageTest {

	@Rule
	public EnvironmentVariables variable = new EnvironmentVariables();
	
	@Test
	public void testOne() {
		Configs conf = new Configs();
		conf.toString();
	}
	
	@Test
	public void testTwo() {
		assertEquals(8080, Configs.port());
	}
	
	@Test
	public void testThree() {
		assertEquals("verify_token", Configs.verifyToken());
	}
	
	@Test
	public void testFour() {
		assertEquals("bot_token", Configs.botToken());
	}
	
	@Test
	public void testFive() {
		variable.set("PORT", "1234");
		variable.set("VERIFY_TOKEN", "token_from_facebook");
		variable.set("BOT_TOKEN", "token_of_the_page");
		assertEquals(1234, Configs.port());
		assertEquals("token_from_facebook", Configs.verifyToken());
		assertEquals("token_of_the_page", Configs.botToken());
	}
	
}
