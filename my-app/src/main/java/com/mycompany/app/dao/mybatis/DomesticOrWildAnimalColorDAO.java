package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.DomesticOrWildAnimalColor;
import com.mycompany.app.models.designpattern.ModelFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DomesticOrWildAnimalColorDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildAnimalColorDAO.class);

    public void createDomesticOrWildAnimalColor(String color, String shade) {
        try(SqlSession session = factory.openSession()) {
            DomesticOrWildAnimalColor domesticOrWildAnimalColor =
                (DomesticOrWildAnimalColor) modelFactory.createModel("DomesticOrWildAnimalColor");
            domesticOrWildAnimalColor.setColor(color);
            domesticOrWildAnimalColor.setShade(shade);

            session.insert("DomesticOrWildAnimalColorMapper.xml.insertDomesticOrWildAnimalColor",
                    domesticOrWildAnimalColor);
            session.commit();
        }
    }

    public DomesticOrWildAnimalColor getDomesticOrWildAnimalColor(int id) {
        DomesticOrWildAnimalColor domesticOrWildAnimalColor =
            (DomesticOrWildAnimalColor) modelFactory.createModel("DomesticOrWildAnimalColor");

        try(SqlSession session = factory.openSession()) {
            HashMap colorResults =
                session.selectOne("DomesticOrWildAnimalColorMapper.xml.selectDomesticOrWildAnimalColor", id);
            domesticOrWildAnimalColor.setColorID((Integer) colorResults.get("ID"));
            domesticOrWildAnimalColor.setColor((String) colorResults.get("Color"));
            domesticOrWildAnimalColor.setShade((String) colorResults.get("Shade"));
            session.commit();
        }

        return domesticOrWildAnimalColor;
    }

    public void updateDomesticOrWildAnimalColor(DomesticOrWildAnimalColor domesticOrWildAnimalColor) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticOrWildAnimalColorMapper.xml.updateDomesticOrWildAnimalColor",
                    domesticOrWildAnimalColor);
            session.commit();
        }
    }
    public void deleteDomesticOrWildAnimalColor(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalColorMapper.xml.deleteDomesticOrWildAnimalColor", id);
            session.commit();
        }
    }
}
