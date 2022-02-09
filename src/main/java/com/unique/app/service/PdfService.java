package com.unique.app.service;

import com.unique.app.setting.PdfUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.exceptions.TemplateInputException;
import org.w3c.dom.Document;

@Service
@RequiredArgsConstructor
public class PdfService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PdfUtils pdfUtils;
    private final TemplateEngine templateEngine;

    public void createPdf() throws TemplateInputException {
        log.info("[ PdfService - createPdf ] - START");

        String pdfTemplate  = "pdf/sample.html";
        Context context     = new Context();
        String emailHtml    = templateEngine.process(pdfTemplate, context);

        Document doc        = pdfUtils.getDocument(emailHtml);

    }
}
