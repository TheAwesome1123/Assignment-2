package com.mycompany.app.database.mybatis;

import com.mycompany.app.models.Owner;
import com.mycompany.app.models.Pet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UpdateMethods {
    private static final Logger LOGGER = LogManager.getLogger(UpdateMethods.class);
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryGetter.getFactory();

    public static void updateTables() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.update("TableAltererMapper.xml.updatePets");
            session.update("TableAltererMapper.xml.updateOwners");
            session.update("TableAltererMapper.xml.updateWildAnimals");
            session.commit();
        }
    }

    public static void updateEntries(List<Object> list) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            for(Object object : list) {
                if(object.getClass().getSimpleName().equals("Owner")) {
                    Owner owner = (Owner) object;
                    owner.setHeight(5.0);
                    UpdateService.updateOwner(owner);
                }
                else if(object.getClass().getSimpleName().equals("Pet")) {
                    Pet pet = (Pet) object;
                    pet.setAge(4);
                    UpdateService.updatePet(pet);
                }
            }

            session.commit();
        }
        catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
