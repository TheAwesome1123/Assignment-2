package com.mycompany.app.enums;

import com.mycompany.app.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

public enum HomeContinent {
    NORTHAMERICA, SOUTHAMERICA, EUROPE, AFRICA, ASIA, AUSTRALIA, ANTARCTICA;

    private final String[] northAmericanCountries = {"United States", "Canada"};
    private final String[] southAmericanCountries = {"Brazil", "Argentina"};
    private final String[] europeanCountries = {"UK", "France"};
    private final String[] africanCountries = {"Algeria", "Cameroon"};
    private final String [] asianCountries = {"China", "Japan"};
    private final String[] australianCountries = {"Australia", "New Zealand"};
    private static final Logger LOGGER = LogManager.getLogger(HomeContinent.class);

    public void getRandomCountry() {
        String[] arrayToUse = this.asianCountries;

        switch (this) {
            case ASIA -> {
                getCountry(arrayToUse, LOGGER);
            }
            case AFRICA -> {
                arrayToUse = this.africanCountries;
                getCountry(arrayToUse, LOGGER);
            }
            case EUROPE -> {
                arrayToUse = this.europeanCountries;
                getCountry(arrayToUse, LOGGER);
            }
            case AUSTRALIA -> {
                arrayToUse = this.australianCountries;
                getCountry(arrayToUse, LOGGER);
            }
            case ANTARCTICA -> {
                System.out.println("No countries here.");
            }
            case NORTHAMERICA -> {
                arrayToUse = this.northAmericanCountries;
                getCountry(arrayToUse, LOGGER);
            }
            case SOUTHAMERICA -> {
                arrayToUse = this.southAmericanCountries;
                getCountry(arrayToUse, LOGGER);
            }
        }
    }

    public void getCountry(String[] pool, Logger logger) {
        int randomIndex = ThreadLocalRandom.current().nextInt(2);
        String country = pool[randomIndex];

        System.out.println("One country that is part of the continent " + this + " is " + country + ".");
    }
}
