package com.mycompany.app.database.mybatis;

import com.mycompany.app.models.designpattern.DesignPatternTesting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

    public static void main(String[] args) {
//        InsertionMethods.insertion();
//        UpdateMethods.updateTables();
//
//        List<Object> items = SelectMethods.selectStuff();
//        UpdateMethods.updateEntries(items);
//        SelectMethods.selectStuff();
//
//        DeleteMethods.deleteStuff();

        DesignPatternTesting.testPatterns();
    }
}
