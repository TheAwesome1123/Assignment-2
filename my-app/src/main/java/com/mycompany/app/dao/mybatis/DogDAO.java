package com.mycompany.app.dao.mybatis;

import com.mycompany.app.services.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.Dog;
import com.mycompany.app.designpattern.ModelFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DogDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DogDAO.class);

    public void createDog(String breed, int petID) {
        try(SqlSession session = factory.openSession()) {
            Dog dog = (Dog) modelFactory.createModel("Dog");
            dog.setBreed(breed);
            dog.setPetID(petID);

            session.insert("DogMapper.xml.insertDog", dog);
            session.commit();
        }
    }

    public Dog getDog(int id) {
        Dog dog = (Dog) modelFactory.createModel("Dog");

        try(SqlSession session = factory.openSession()) {
            HashMap dogResults = session.selectOne("DogMapper.xml.selectDog", id);
            dog.setDogID((Integer) dogResults.get("ID"));
            dog.setBreed((String) dogResults.get("Breed"));
            dog.setPetID((Integer) dogResults.get("Pet_ID"));
            session.commit();
        }

        return dog;
    }
    public void updateDog(Dog dog) {
        try(SqlSession session = factory.openSession()) {
            session.update("DogMapper.xml.updateDog", dog);
            session.commit();
        }
    }
    public void deleteDog(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("DogMapper.xml.deleteDog", id);
            session.commit();
        }
    }
}
