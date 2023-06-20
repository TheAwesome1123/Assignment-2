package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.WildAnimalAndColorRelation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class WildAnimalsAndColorsDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalsAndColorsDAO.class);

    public void createWildAnimalAndColorRelation(int wildAnimalID, int colorID) {
        try(SqlSession session = factory.openSession()) {
            session.insert("WildAnimalsAndColorsMapper.xml.insertWildAnimalsAndColors");
        }
    }

    public WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        WildAnimalAndColorRelation relation = new WildAnimalAndColorRelation();

        try(SqlSession session = factory.openSession()) {
            HashMap results = session.selectOne("WildAnimalsAndColorsMapper.xml.selectWildAnimalsAndColors", id);
            relation.setRelationID((Integer) results.get("ID"));
            relation.setColorID((Integer) results.get("Color_ID"));
            relation.setWildAnimalID((Integer) results.get("WildAnimal_ID"));
        }

        return relation;
    }

    public void updateWildAnimalAndColorRelation(int id, int wildAnimalID, int colorID) {
        try(SqlSession session = factory.openSession()) {
            session.update("WildAnimalsAndColorsMapper.xml.updateWildAnimalsAndColors");
        }
    }
    public void deleteWildAnimalAndColorRelation(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("WildAnimalsAndColorsMapper.xml.deleteWildAnimalsAndColors", id);
        }
    }
}
