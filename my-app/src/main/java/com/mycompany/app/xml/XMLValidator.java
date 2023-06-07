package com.mycompany.app.xml;

import javax.xml.parsers.DocumentBuilderFactory;

public class XMLValidator {
    private static final String w3 = "http://www.w3.org/2001/XMLSchema";
    private static final String jaxp =  "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    public static void validate() {
        DocumentBuilderFactory documentBuilderFactory = XMLMain.getDocumentBuilderFactory();
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setAttribute(jaxp, "Animal Schema.xsd");
    }
}
