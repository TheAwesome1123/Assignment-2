package com.mycompany.app.streams;

import com.mycompany.app.abstracts.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetFirstXAnimalsInList {
    private static final Logger LOGGER = LogManager.getLogger(GetFirstXAnimalsInList.class);

    public static void getFirstXAnimalsInList(List<Animal> list, int num) {
        if(num > list.size()) {
            LOGGER.info("List is too small.");
            return;
        }
        else if(num < 0) {
            LOGGER.info("Number can't be negative.");
            return;
        }

        list.stream().limit(num).forEach(LOGGER::info);
    }
}
