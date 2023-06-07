package com.mycompany.app.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    private static Document document;

    public static void makeParser() {
        try {
            DocumentBuilderFactory documentBuilderFactory = XMLMain.getDocumentBuilderFactory();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setValidating(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(XMLMain.getFile());
            document.getDocumentElement().normalize();

            parse();
        }
        catch(Exception e) {
            LOGGER.info(e);
        }
    }

    public static void parse() {
        // Root.
        NodeList nodeList = document.getChildNodes();

        // There should only be 1.
        Node root = nodeList.item(0);
        NodeList listOfNodesInRoot = root.getChildNodes();

        // The 5 elements that represent classes.
        for(int j = 0; j < listOfNodesInRoot.getLength(); j++) {
            Node currentElement = listOfNodesInRoot.item(j);

            if(currentElement.getNodeType() == Node.ELEMENT_NODE) {
                LOGGER.info("\nClass: " + currentElement.getNodeName());
            }

            NodeList elementProperties = currentElement.getChildNodes();

            // Properties.
            for(int k = 0; k < elementProperties.getLength(); k++) {
                Node property = elementProperties.item(k);

                if(property.getNodeType() == Node.ELEMENT_NODE) {
                    LOGGER.info("Property Type: " + property.getNodeName() +
                        ", Property Name: " + property.getTextContent());
                }
            }
        }
    }
}
