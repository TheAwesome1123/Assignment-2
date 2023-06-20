package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.WildAnimal;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class WildAnimalDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalDAO.class);

    public void createWildAnimal(String type, boolean isDomesticated, String name, int ownerID, int animalID) {
        try(SqlSession session = factory.openSession()) {
            session.insert("WildAnimalMapper.xml.insertWildAnimal");
        }
    }

    public WildAnimal getWildAnimal(int id) {
        WildAnimal wildAnimal = new WildAnimal();

        try(SqlSession session = factory.openSession()) {
            HashMap results = session.selectOne("WildAnimalMapper.xml.selectWildAnimal", id);
            wildAnimal.setWildAnimalID((Integer) results.get("ID"));
            wildAnimal.setWildAnimalType((String) results.get("Type"));
            wildAnimal.setAnimalID((Integer) results.get("Animal_ID"));
        }

        return wildAnimal;
    }

    public void updateWildAnimal(int id, String isDomesticated) {
        try(SqlSession session = factory.openSession()) {
            session.update("WildAnimalMapper.xml.updateWildAnimal");
        }
    }

    public void deleteWildAnimal(int id) {
        try(SqlSession session = factory.openSession()) {
            session.delete("WildAnimalMapper.xml.deleteWildAnimal", id);
        }
    }
}