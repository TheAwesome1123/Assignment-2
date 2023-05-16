package com.mycompany.app.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum BearType {
    BROWN, BLACK, GRIZZLY, POLAR;

    private static final Logger LOGGER = LogManager.getLogger(BearType.class);

    public void printInfo() {
        if(this.equals(BearType.POLAR)) {
            LOGGER.info("This bear has white fur.");
        }
        else {
            LOGGER.info("This bear has darker fur.");
        }
    }
}
