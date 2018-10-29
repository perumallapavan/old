package com.sample.address.managment;

import junit.framework.TestCase;

public class MonitorAddressTest extends TestCase {

	private MonitorAddressBean monitorAddressbean;
	
	protected void setUp() throws Exception {
		super.setUp();
		monitorAddressbean= new MonitorAddressBean();
		}
	
	public void testMonitorURL() {

		assertEquals(true, monitorAddressbean.monitorURL("http://www.regis24.de/impressum.php"));
		}
	

}
