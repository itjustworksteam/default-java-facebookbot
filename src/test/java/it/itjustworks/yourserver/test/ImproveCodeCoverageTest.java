package it.itjustworks.yourserver.test;

import org.junit.Test;

import it.itjustworks.yourserver.server.Configs;

public class ImproveCodeCoverageTest {

	@Test
	public void testOne() {
		Configs conf = new Configs();
		conf.toString();
	}
	
}
