package com.mycompany.app.services.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionMethods {
    private static final Logger LOGGER = LogManager.getLogger(InsertionMethods.class);
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryGetter.getFactory();

    public static void insertion() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            InsertService.insertAnimal("Pet", "Male");
            InsertService.insertOwner("Bob", "Johnson");
            InsertService.insertPet("Dog", "Max", 1, 1);
            InsertService.insertDog("German Shepherd", 1);

            InsertService.insertAnimal("Wild", "Female");
            InsertService.insertWildAnimal("Wolf", 2);
            InsertService.insertHomeContinent("North America", 1);
            InsertService.insertHomeContinent("Europe", 1);
            InsertService.insertWildAnimalColor("Gray", "Normal");
            InsertService.insertWildAnimalColor("Gray", "Light");
            InsertService.insertWildAnimalAndColorRelation(1, 1);
            InsertService.insertWildAnimalAndColorRelation(2, 1);

            session.commit();
        }
        catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
