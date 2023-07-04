package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.Cat;
import com.mycompany.app.models.designpattern.ModelFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class CatDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(CatDAO.class);

    public void createCat(String breed, int petID) {
        try(SqlSession session = factory.openSession()) {
            Cat cat = (Cat) modelFactory.createModel("Cat");
            cat.setBreed(breed);
            cat.setPetID(petID);

            session.insert("CatMapper.xml.insertCat", cat);
            session.commit();
        }
    }

    public Cat getCat(int id) {
        Cat cat = (Cat) modelFactory.createModel("Cat");

        try(SqlSession session = factory.openSession()) {
            HashMap catResults = session.selectOne("CatMapper.xml.selectCat", id);
            cat.setCatID((Integer) catResults.get("ID"));
            cat.setBreed((String) catResults.get("Breed"));
            cat.setPetID((Integer) catResults.get("Pet_ID"));

            session.commit();
        }

        return cat;
    }
    public void updateCat(Cat cat) {
        try(SqlSession session = factory.openSession()) {
            session.update("CatMapper.xml.updateCat", cat);
            session.commit();
        }
    }
    public void deleteCat(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("CatMapper.xml.deleteCat", id);
            session.commit();
        }
    }
}
