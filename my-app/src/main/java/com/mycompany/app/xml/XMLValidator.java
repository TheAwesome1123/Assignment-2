package com.mycompany.app.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class XMLValidator {
    private static final Logger LOGGER = LogManager.getLogger(XMLValidator.class);

    public static void validate() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source fileWithSchema = new StreamSource(XMLMain.getSchema());
            Schema schema = schemaFactory.newSchema(fileWithSchema);
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(XMLMain.getPetFile()));

        }
        catch(SAXException | IOException saxe) {
            LOGGER.info(saxe);
        }
    }
}
