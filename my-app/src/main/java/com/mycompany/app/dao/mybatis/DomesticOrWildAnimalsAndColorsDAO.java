package com.mycompany.app.dao.mybatis;

import com.mycompany.app.services.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.DomesticOrWildAnimalAndColorRelation;
import com.mycompany.app.designpattern.ModelFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

public class DomesticOrWildAnimalsAndColorsDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildAnimalsAndColorsDAO.class);

    public void createDomesticOrWildAnimalAndColorRelation(int domesticOrWildAnimalID, int colorID) {
        try(SqlSession session = factory.openSession()) {
            DomesticOrWildAnimalAndColorRelation relation =
                (DomesticOrWildAnimalAndColorRelation) modelFactory.createModel("DomesticOrWildAnimalAndColorRelation");
            relation.setDomesticOrWildAnimalID(domesticOrWildAnimalID);
            relation.setColorID(colorID);

            session.insert("DomesticOrWildAnimalsAndColorsMapper.xml.insertDomesticOrWildAnimalsAndColors",
                relation);
            session.commit();
        }
    }

    public DomesticOrWildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(int id) {
        DomesticOrWildAnimalAndColorRelation relation =
            (DomesticOrWildAnimalAndColorRelation) modelFactory.createModel("DomesticOrWildAnimalAndColorRelation");

        try(SqlSession session = factory.openSession()) {
            HashMap results =
                session.selectOne("DomesticOrWildAnimalsAndColorsMapper.xml.selectDomesticOrWildAnimalsAndColors", id);
            relation.setRelationID((Integer) results.get("ID"));
            relation.setColorID((Integer) results.get("Color_ID"));
            relation.setDomesticOrWildAnimalID((Integer) results.get("DomesticOrWildAnimal_ID"));
            session.commit();
        }

        return relation;
    }

    public void updateDomesticOrWildAnimalAndColorRelation(DomesticOrWildAnimalAndColorRelation relation) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticOrWildAnimalsAndColorsMapper.xml.updateDomesticOrWildAnimalsAndColors",
                relation);
            session.commit();
        }
    }
    public void deleteDomesticOrWildAnimalAndColorRelation(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalsAndColorsMapper.xml.deleteDomesticOrWildAnimalsAndColors", id);
            session.commit();
        }
    }
}
