package com.unique.app.setting;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PdfUtils {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public org.w3c.dom.Document getDocument(String type) {
        log.info("[ PdfUtils - getDocument ] - START");

        Document document           = Jsoup.parse(type, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        org.w3c.dom.Document doc    = new W3CDom().fromJsoup(document);

        return doc;
    }
}
