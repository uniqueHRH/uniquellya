package com.unique.app.main.controller;

import com.unique.app.service.MailService;
import com.unique.app.setting.Constants;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@Controller
@AllArgsConstructor
public class MailController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private MailService mailService;
    private JavaMailSender mailSender;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String sendMail  (@RequestParam("name") String name
                           , @RequestParam("email") String recMail) throws MessagingException {
        log.info("[ MailController - sendMail ] - START");

        String email    = recMail;
        String result   = Constants.SEND_MAIL_SUCCESS;

        mailService.sendMail(name, email);

        log.debug("result === "+ result);
        return result;
    }
}
