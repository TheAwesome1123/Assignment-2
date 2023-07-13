package com.mycompany.app.dao.mybatis;

import com.mycompany.app.services.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.Animal;
import com.mycompany.app.designpattern.ModelFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;


public class AnimalDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(AnimalDAO.class);

    public void createAnimal(String type, String sex) {
        try(SqlSession session = factory.openSession()) {
            Animal animal = (Animal) modelFactory.createModel("Animal");
            animal.setSex(sex);
            animal.setType(type);

            session.insert("AnimalMapper.xml.insertAnimal", animal);
            session.commit();
        }
    }

    public Animal getAnimal(int id) {
        Animal animal = (Animal) modelFactory.createModel("Animal");

        try(SqlSession session = factory.openSession()) {
            HashMap animalResults = session.selectOne("AnimalMapper.xml.selectAnimal", id);
            animal.setID((Integer) animalResults.get("ID"));
            animal.setType((String) animalResults.get("Type"));
            animal.setSex((String) animalResults.get("Sex"));
            session.commit();
        }

        return animal;
    }
    public void updateAnimal(Animal animal) {
        try(SqlSession session = factory.openSession()) {
            session.update("AnimalMapper.xml.updateAnimal", animal);
            session.commit();
        }
    }
    public void deleteAnimal(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("AnimalMapper.xml.deleteAnimal", id);
            session.commit();
        }
    }
}
