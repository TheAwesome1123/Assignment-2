package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.designpattern.ModelFactory;

import com.mycompany.app.models.WildAnimalAndColorRelation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class WildAnimalsAndColorsDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalsAndColorsDAO.class);

    public void createWildAnimalAndColorRelation(int wildAnimalID, int colorID) {
        try(SqlSession session = factory.openSession()) {
            WildAnimalAndColorRelation relation =
                (WildAnimalAndColorRelation) modelFactory.createModel("WildAnimalAndColorRelation");
            relation.setColorID(colorID);
            relation.setWildAnimalID(wildAnimalID);

            session.insert("WildAnimalsAndColorsMapper.xml.insertWildAnimalsAndColors", relation);
            session.commit();
        }
    }

    public WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        WildAnimalAndColorRelation relation =
                (WildAnimalAndColorRelation) modelFactory.createModel("WildAnimalAndColorRelation");

        try(SqlSession session = factory.openSession()) {
            HashMap results = session.selectOne("WildAnimalsAndColorsMapper.xml.selectWildAnimalsAndColors", id);
            relation.setRelationID((Integer) results.get("ID"));
            relation.setColorID((Integer) results.get("Color_ID"));
            relation.setWildAnimalID((Integer) results.get("WildAnimal_ID"));
            session.commit();
        }

        return relation;
    }

    public void updateWildAnimalAndColorRelation(WildAnimalAndColorRelation relation) {
        try(SqlSession session = factory.openSession()) {
            session.update("WildAnimalsAndColorsMapper.xml.updateWildAnimalsAndColors", relation);
            session.commit();
        }
    }
    public void deleteWildAnimalAndColorRelation(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("WildAnimalsAndColorsMapper.xml.deleteWildAnimalsAndColors", id);
            session.commit();
        }
    }
}
