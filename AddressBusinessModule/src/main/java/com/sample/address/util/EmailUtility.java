package com.sample.address.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.NamingException;
import javax.activation.*;

/**
 * Contains utility method to send email
 * 
 * @author A.Ijaz
 * @version 0.1
 */
public class EmailUtility {

	/**
	 * send email method
	 * 
	 * @param subject
	 *            subject of the email
	 * @param body
	 *            body text of the email
	 */
	public static void sendEmail(String subject, String body) {

		// Recipient's email ID needs to be mentioned.
		String to = "mail@regis24.com";

		// Sender's email ID needs to be mentioned
		String from = "notificatin@addressmonitor.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			message.setSubject(subject);
			message.setText(body);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
