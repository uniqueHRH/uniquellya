package com.unique.app.service;

import com.unique.app.setting.Constants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PdfService pdfService;
    private final JavaMailSender mailSender;

    @Value("${spring.mail.user")
    private String sender;

    public void sendMail(String name, String email) throws MessagingException {
        log.info("[ MailService - sendMail ] - START");

        pdfService.createPdf();

        MimeMessage msg             = mailSender.createMimeMessage();
        MimeMessageHelper helper    = new MimeMessageHelper(msg, true);

        helper.setTo(email);
        helper.setSubject(name+ Constants.SEND_CERTIFICATE);
        helper.setFrom(sender);
        helper.setText("Hi, Nice to meet you");

        mailSender.send(msg);
    }
}
