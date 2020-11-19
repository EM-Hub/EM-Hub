package com.spring.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
   
    public class EmailSender  {
         
        @Autowired
        protected JavaMailSender  mailSender;
        public void SendEmail(Email email) throws Exception {
             
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true);
            try {
            	messageHelper.setSubject(email.getSubject());
            	messageHelper.setText(email.getContent(), true);
                msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email.getReceiver()));
               
            }catch(MessagingException e) {
                System.out.println("MessagingException");
                e.printStackTrace();
            }
            
            
            try {
                mailSender.send(msg);
            }catch(MailException e) {
                System.out.println("MailException발생");
                e.printStackTrace();
            }
            

            
        }
        
}


