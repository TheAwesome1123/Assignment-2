package com.mycompany.app.xml;

import java.io.File;

import org.apache.logging.log4j.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLMain {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private static File file;

    public static void main(String[] args ){
        try {
            // Find file.
            file = new File("my-app/src/main/java/com/mycompany/app/xml/Animals.xml");
            LOGGER.info("Found file " + file.getName());

            doParsing();
            XMLValidator.validate();
        }
        catch(NullPointerException npe) {
            LOGGER.info("File not found; quitting.");
        }
    }

    public static void doParsing() {
        XMLParser.makeParser();
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        return documentBuilderFactory;
    }

    public static File getFile() {
        return file;
    }
}
