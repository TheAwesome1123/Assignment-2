package com.mycompany.app.xml.pet;

import com.mycompany.app.xml.XMLMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOfBirthAdapter extends XmlAdapter<String, Date> {
    private static final String format = "MM/dd/yy";
    private static final Logger LOGGER = LogManager.getLogger(DateOfBirthAdapter.class);

    @Override
    public Date unmarshal(String v) {
        try {
            return new SimpleDateFormat(format).parse(v);
        }
        catch(Exception e) {
            LOGGER.info(e);
            return null;
        }
    }

    @Override
    public String marshal(Date v) {
        return new SimpleDateFormat(format).format(v);

    }
}
