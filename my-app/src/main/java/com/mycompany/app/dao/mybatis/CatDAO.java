package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.Cat;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class CatDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(CatDAO.class);

    public void createCat(String breed) {
        try(SqlSession session = factory.openSession()) {
            session.insert("CatMapper.xml.createCat");
        }
    }

    public Cat getCat(int id) {
        Cat cat = new Cat();

        try(SqlSession session = factory.openSession()) {
            HashMap catResults = session.selectOne("CatMapper.xml.selectCat");
            cat.setCatID((Integer) catResults.get("ID"));
            cat.setBreed((String) catResults.get("Breed"));
            cat.setPetID((Integer) catResults.get("Pet_ID"));
        }

        return cat;
    }
    public void updateCat(int id) {
        try(SqlSession session = factory.openSession()) {
            session.update("CatMapper.xml.updateCat");
        }
    }
    public void deleteCat(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("CatMapper.xml.deleteCat", id);
        }
    }
}
