package com.mycompany.app.xml;

import java.io.File;

import org.apache.logging.log4j.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLMain {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    private static File file;

    public static void main(String[] args ){
        try {
            // Find file.
            file = new File("Animals.xml");
            LOGGER.info("Found file " + file.getName());

            doParsing();
        }
        catch(NullPointerException npe) {
            LOGGER.info("File not found; quitting.");
        }
    }

    public static void doParsing() {
        XMLParser.makeParser();
    }
}
