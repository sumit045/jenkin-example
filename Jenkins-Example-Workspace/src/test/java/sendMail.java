import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;


public class sendMail {

	static final String myAccount = "sumit619.hellboy@gmail.com";
	static final String password = "iwilltakeyou2hell";
	
	public static void main(String[] args) throws MessagingException {
		
		new sendMail().mailTrigger("lazymowgli@gmail.com");

	}

	public static void mailTrigger(String recipient) throws MessagingException
	{
		System.out.println("Preparing message");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(myAccount, password);
			}
		});
		
		Message message = prepareMessage(session, recipient);
		
		Transport.send(message);
		System.out.println("Message sent successfully");
	}
	
	public static Message prepareMessage(Session session, String recipient) 
	{
		try 
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("My first message");
			message.setText("Chla gya?");
			return message;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	
}
