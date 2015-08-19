/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pwp;

/**
 *
 * @author Geofrey Nyabuto
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import pwp.dbConn;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Send_Data {
public String filenames,cu,dates,computername,senderofmail;
        
 String full_date;
    public Send_Data(){
    }  
 public boolean Sendattachment (String date,String path,String comp,String senderofemail,String mail,String county,String partner,String createdOn,String usermail)throws MessagingException {
     String toAddress="";
     
      if(mail.contains("_")){
          mail=mail.replace("_", ",");
      }
     System.out.println("sender of mail is  :  "+senderofemail);
        filenames=path; 
        full_date=date;
        computername=comp;
        senderofmail=senderofemail;
        String textBody="Hi ,\n Attached is PWP Data Back up as at "+full_date+" "+senderofemail+" and email address "+usermail+"."
                + "\n"
                + "*******************TO MERGE THIS DATA : \n" +
"(1)Download the attachment to any folder of choice.\n" +
"(2)Move your mouse over the Data menu and select Merge Data.\n" +
"(3)From the merging page that opens, click Browse and select the sql file you have downloaded.\n" +
"(4)Click on Merge and wait for a success message.\n\n"
+ "*************NOTE: Users who created this backup dont need to merge the data again*********"
+ "\n*******THIS IS A SYSTEM AUTO-GENERATED MESSAGE*****";
//        toAddress="mwambage@gmail.com,ekmanukaka5@gmail.com";
        String host = "smtp.gmail.com";
        String Password ="plusaphia";
        String from = "aphiabackup@gmail.com";
        toAddress=mail;
        System.out.println("too address   :  "+toAddress);
        // toAddress = "aphiapluschwsattendance@gmail.com";  filled above...
        String filename = filenames;
        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("PWP SQL DATA BACK_UP From : "+computername);

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(textBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filename);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName("PWP_V1_20_AUGUST_2015_"+county.trim()+"_"+partner.trim()+"_Data_"+createdOn.trim()+".sql");
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        try {
            javax.mail.Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();
            
            return true;

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
            return false;
        }
    }

//    public static void main(String args[]) {
////        try {
////            SendMail sm = new SendMail();
////        } catch (MessagingException ex) {
////            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }
}
