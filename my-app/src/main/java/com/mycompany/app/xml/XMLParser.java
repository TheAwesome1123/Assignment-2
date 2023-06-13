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
    private static final Logger LOGGER = LogManager.getLogger(XMLParser.class);
    private static Document document;

    public static void doParsing(File file) {
        try {
            DocumentBuilderFactory documentBuilderFactory = XMLMain.getDocumentBuilderFactory();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            parse();
        }
        catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static void parse() {
        Node root = document.getDocumentElement();

        LOGGER.info("Root: " + root.getNodeName());

        // Elements in main one.
        NodeList listOfNodesInRoot = root.getChildNodes();
        printElements(listOfNodesInRoot);
    }

    public static void printElements(NodeList list) {
        for(int i = 0; i < list.getLength(); i++) {
            Node currentElement = list.item(i);

            if(currentElement.getNodeType() == Node.ELEMENT_NODE && getChildNodesThatAreElements(currentElement) > 0) {
                LOGGER.info("Element: " + currentElement.getNodeName());
            }
            else if (currentElement.getNodeType() == Node.ELEMENT_NODE) {
                LOGGER.info("Element: " + currentElement.getNodeName() + ", Value: " + currentElement.getTextContent());
            }

            printElements(currentElement.getChildNodes());
        }
    }

    public static int getChildNodesThatAreElements(Node node) {
        NodeList children = node.getChildNodes();
        int numOfChildrenThatAreElements = 0;

        for(int i = 0; i < children.getLength(); i++) {
            if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                numOfChildrenThatAreElements++;
            }
        }

        return numOfChildrenThatAreElements;
    }
}
