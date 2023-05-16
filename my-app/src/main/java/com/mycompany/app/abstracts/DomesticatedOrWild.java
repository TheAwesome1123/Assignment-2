package com.mycompany.app.abstracts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class DomesticatedOrWild extends Animal {
    protected boolean isDomesticated;
    protected String name;
    protected String breed;
    protected int age;
    protected String owner;
    protected static final Logger LOGGER = LogManager.getLogger("DomesticatedOrWildLogger");

}
