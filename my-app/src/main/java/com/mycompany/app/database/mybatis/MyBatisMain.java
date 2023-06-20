package com.mycompany.app.database.mybatis;

import com.mycompany.app.database.jdbc.DatabaseMain;
import com.mycompany.app.database.jdbc.TableAlterer;
import com.mycompany.app.models.Animal;
import com.mycompany.app.models.Owner;
import com.mycompany.app.models.Pet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(DatabaseMain.class);
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryGetter.getFactory();
    private static Owner owner;
    private static Pet pet;
    private static Animal animal;

    public static void main(String[] args) {
        insertion();
        updateTables();
        selectStuff();
        updateEntries();
        selectStuff();
        deleteOwner();
    }

    public static void insertion() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            InsertService.insertAnimal("Pet", "Male");
            InsertService.insertOwner("Bob", "Johnson");
            InsertService.insertPet("Dog", "Max", 1, 1);

            session.commit();
        }
        catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static void selectStuff() {
        owner = (SelectService.getOwner(1));
        pet = SelectService.getPet(1);

        LOGGER.info(pet.getPetType());
        LOGGER.info(pet.getName());

        if(pet.getAge() != null) {
            LOGGER.info(pet.getAge());
        }

        LOGGER.info(pet.getOwnerID());
        LOGGER.info(pet.getAnimalID() + "\n");

        LOGGER.info(owner.getFirstName());
        LOGGER.info(owner.getLastName());

        if(owner.getHeight() != null) {
            LOGGER.info(owner.getHeight() + "\n");
        }
    }

    public static void updateTables() {
        TableAlterer.updatePetTable();
        TableAlterer.updateWildAnimalTable();
        TableAlterer.updateOwnerTable();
    }

    public static void updateEntries() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            owner.setHeight(5.0);
            pet.setAge(4);
            UpdateService.updatePet(pet);
            UpdateService.updateOwner(owner);
            session.commit();
        }
        catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static void deleteOwner() {
        DeleteService.deleteOwner(1, pet);
    }
}
