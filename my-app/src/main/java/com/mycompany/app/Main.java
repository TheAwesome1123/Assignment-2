package com.mycompany.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.*; // https://sematext.com/blog/log4j2-tutorial/

public class Main {
    private static final Logger NEW_LOGGER = LogManager.getLogger(Main.class);

    static {
        NEW_LOGGER.info("Starting.");
        NEW_LOGGER.info("Welcome; please follow the next prompt.");
    }
    
    public static void main(String[] args) {
        // Start.
        int input;
        NEW_LOGGER.info("Press 1 to continue: ");
        Scanner scanner = new Scanner(System.in);

        try {
            input = scanner.nextInt();
        }
        catch(InputMismatchException ime) {
            NEW_LOGGER.info("Invalid input; quitting.");
            scanner.close();
            return;
        }
        
        if(input == 1) {
            printDetails(NEW_LOGGER);
            NEW_LOGGER.info("Making animals.");
            MainInitMethods.makeAnimals(NEW_LOGGER);
        }
        else {
            NEW_LOGGER.info("Input wasn't 1; quitting.");
        }
        
        scanner.close();
    }

    public static void printDetails(Logger logger) {
        logger.info("Order of operations:");
        logger.info("1. Create animal objects (not shown here).");
        logger.info("2. Use methods in animal classes.");
        logger.info("3. Use interface methods.");
        logger.info("-----------------");
    }
}