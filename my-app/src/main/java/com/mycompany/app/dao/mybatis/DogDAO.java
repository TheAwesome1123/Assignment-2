package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.Dog;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DogDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DogDAO.class);

    public void createDog(String breed) {
        try(SqlSession session = factory.openSession()) {
            session.insert("DogMapper.xml.createDog");
        }
    }

    public Dog getDog(int id) {
        Dog dog = new Dog();

        try(SqlSession session = factory.openSession()) {
            HashMap dogResults = session.selectOne("DogMapper.xml.selectDog");
            dog.setDogID((Integer) dogResults.get("ID"));
            dog.setBreed((String) dogResults.get("Breed"));
            dog.setPetID((Integer) dogResults.get("Pet_ID"));
        }

        return dog;
    }
    public void updateDog(int id) {
        try(SqlSession session = factory.openSession()) {
            session.update("DogMapper.xml.updateDog");
        }
    }
    public void deleteDog(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("DogMapper.xml.deleteDog", id);
        }
    }
}
