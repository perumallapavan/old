package com.sample.persistence.utilities.context;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ContextUtilities {

	
	
	/**
	 * Retrieves a JDBC connection from JNDI bound datasource
	 * @param the JNDI name of the datasource
	 * @return the the connection
	 * @throws NamingException
	 */
	public static Connection getConnection(String dataSourceName) throws NamingException, SQLException {
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(dataSourceName);
			return ds.getConnection();
		} finally {
			try {
				if (ctx != null)
					ctx.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
