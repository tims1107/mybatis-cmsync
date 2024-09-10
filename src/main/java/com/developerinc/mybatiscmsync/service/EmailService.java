package com.developerinc.mybatiscmsync.service;






import com.developerinc.mybatiscmsync.model.EmailAttachData;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;




import java.io.File;
import java.util.List;
import java.util.Objects;

@Service

public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailAttachDataService emailAttachDataService;

    public void sendEmailWithAttachment(String to, String [] cc, String subject, String body, String attachmentPath) throws MessagingException {


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);



        helper.setTo(to);
        helper.setCc(cc);
        helper.setSubject(subject);
        helper.setText(body);

        // Get the file as a resource
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(attachmentPath)).getFile());




        helper.addAttachment(file.getName(), file);

        javaMailSender.send(mimeMessage);
    }
}