package com.mycompany.app.database.mybatis;

import java.util.List;

public class MyBatisMain {
    public static void main(String[] args) {
        InsertionMethods.insertion();
        UpdateMethods.updateTables();

        List<Object> items = SelectMethods.selectStuff();
        UpdateMethods.updateEntries(items);
        SelectMethods.selectStuff();

        DeleteMethods.deleteStuff();
    }
}
