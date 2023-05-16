package com.mycompany.app.enums;

import org.apache.logging.log4j.*;

public enum CatBreed {
    AMERICANSHORTHAIR, SIAMESE;

    private static final Logger LOGGER = LogManager.getLogger(CatBreed.class);

    public void printInfo() {
        LOGGER.info("This cat is not a purebred.");
    }
}
