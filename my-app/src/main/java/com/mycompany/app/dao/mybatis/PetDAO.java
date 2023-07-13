package com.mycompany.app.dao.mybatis;

import com.mycompany.app.services.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.designpattern.ModelFactory;
import com.mycompany.app.models.Pet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

public class PetDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(PetDAO.class);

    public void createPet(String type, String name, int ownerID, int animalID) {
        try(SqlSession session = factory.openSession()) {
            Pet pet = (Pet) modelFactory.createModel("Pet");
            pet.setPetType(type);
            pet.setName(name);
            pet.setOwnerID(ownerID);
            pet.setAnimalID(animalID);

            session.insert("PetMapper.xml.insertPet", pet);
            session.commit();
        }
    }

    public Pet getPet(int id) {
        Pet pet = (Pet) modelFactory.createModel("Pet");

        try(SqlSession session = factory.openSession()) {
            HashMap petResults = session.selectOne("PetMapper.xml.selectPet", id);
            pet.setPetID((Integer) petResults.get("ID"));
            pet.setPetType((String) petResults.get("Type"));
            pet.setName((String) petResults.get("Name"));
            pet.setAnimalID((Integer) petResults.get("Animal_ID"));
            pet.setOwnerID((Integer) petResults.get("Owner_ID"));

            if(petResults.get("Age") != null) {
                pet.setAge((Integer) petResults.get("Age"));
            }

            session.commit();
        }

        return pet;
    }

    public void updatePet(Pet pet) {
        try(SqlSession session = factory.openSession()) {
            session.update("PetMapper.xml.updatePet", pet);
            session.commit();
        }
    }

    private static void deletePet(int petID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("PetMapper.xml.deletePet", petID);
            session.commit();
        }
    }
}
