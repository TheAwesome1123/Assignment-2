package com.mycompany.app.database.mybatis;

public class DeleteMethods {
    public static void deleteStuff() {
        DeleteService.deleteOwner(1);
        DeleteService.deleteWildAnimal(1);
    }
}
