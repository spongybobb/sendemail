import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class sendemail {
    public static void main(String [] args){
        String to = "hongzhang.chen17@imperial.ac.uk";//change accordingly
        String from = "chenhongzhang98@gmail.com";//change accordingly
        String host = "155.198.99.121";//or IP address


        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){

            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("chenhongzhang98@gmail.com", "t.chen1998");
            }
        });

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        }catch (MessagingException mex) {mex.printStackTrace();}
    }


}