/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample programe. Please contact Sample org, fakestr. 17, 
 * 40667 Dusseldorf, Germany or visit www.sample.com if you need additional 
 * information or have any questions.
 */

package com.sample.address.managment;

import javax.ejb.Local;

/**
 * This class monitor URL for Address and check if address has changed
 * 
 * @author A.Ijaz
 * @version 0.1
 */
@Local
public interface MonitorAddressBeanLocal {

	/**
	 * Crawle URL and montior address
	 * 
	 * @param URL
	 *            The url to monitor
	 * @return true if transection successful otherwise false
	 * 
	 */
	public boolean monitorURL(String url);

}
