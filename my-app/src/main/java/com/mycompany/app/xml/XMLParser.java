package com.mycompany.app.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLParser {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    private static Document document;

    public static void doParsing(boolean fileHasOneElement) {
        try {
            DocumentBuilderFactory documentBuilderFactory = XMLMain.getDocumentBuilderFactory();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setValidating(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(XMLMain.getFile());
            document.getDocumentElement().normalize();

            parse(fileHasOneElement);
        }
        catch(Exception e) {
            LOGGER.info(e);
        }
    }

    public static void parse(boolean fileHasOneElement) {
        Node root = document.getDocumentElement();

        if(!(fileHasOneElement)) {
            LOGGER.info("Main Element: " + root.getNodeName());
        }
        else {
            LOGGER.info("Element: " + root.getNodeName() + "\n");
        }

        // Elements in main one.
        NodeList listOfNodesInRoot = root.getChildNodes();

        for(int j = 0; j < listOfNodesInRoot.getLength(); j++) {
            Node currentElement = listOfNodesInRoot.item(j);

            if(currentElement.getNodeType() == Node.ELEMENT_NODE) {
                if(!(fileHasOneElement)) {
                    LOGGER.info("\nSecondary Element: " + currentElement.getNodeName());
                }
                else {
                    LOGGER.info("Property Type: " + currentElement.getNodeName() +
                            ", Property Value: " + currentElement.getTextContent());
                }
            }

            NodeList elementProperties = currentElement.getChildNodes();

            if(!(fileHasOneElement)) {
                for(int k = 0; k < elementProperties.getLength(); k++) {
                    Node property = elementProperties.item(k);

                    if(property.getNodeType() == Node.ELEMENT_NODE) {
                        LOGGER.info("Property Type: " + property.getNodeName() +
                                ", Property Value: " + property.getTextContent());
                    }
                }
            }
        }
    }
}
