package com.mycompany.app.xml;

import java.io.File;
import org.apache.logging.log4j.*;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLMain {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private static File file;
    private static File schema;

    public static void main(String[] args ){
        try {
            // Find files.
            file = new File("my-app/src/main/java/com/mycompany/app/xml/Pet.xml");
            schema = new File("my-app/src/main/java/com/mycompany/app/xml/Pet.xsd");
            LOGGER.info("Found file " + file.getName());
            LOGGER.info("Found file " + schema.getName());

            XMLParser.doParsing(true);
            XMLValidator.validate();
        }
        catch(NullPointerException npe) {
            LOGGER.info("File not found; quitting.");
        }
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        return documentBuilderFactory;
    }

    public static File getFile() {
        return file;
    }

    public static File getSchema() {
        return schema;
    }

}
