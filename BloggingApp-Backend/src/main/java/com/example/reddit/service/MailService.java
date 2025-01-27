package com.example.reddit.service;

import com.example.reddit.exception.CustomException;
import com.example.reddit.model.NotificationEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public void sendEmail(NotificationEmail notificationEmail) throws CustomException {
        logger.info("{}", "In send mail");
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("someone@reddit.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
        };
        try {
            mailSender.send(messagePreparator);
            logger.info("{}", "Activation email sent!!");
        } catch (MailException e) {
            throw new CustomException("Exception occurred when sending mail to " + notificationEmail.getRecipient());
        }

    }


}
