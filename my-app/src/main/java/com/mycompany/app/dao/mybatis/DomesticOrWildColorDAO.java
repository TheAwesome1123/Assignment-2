package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.DomesticOrWildColor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DomesticOrWildColorDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildColorDAO.class);

    public void createDomesticOrWildAnimalColor(int domesticOrWildAnimalID, int colorID) {
        try(SqlSession session = factory.openSession()) {
            session.insert("DomesticOrWildAnimalColorMapper.xml.insertDomesticOrWildAnimalColor");
        }
    }

    public DomesticOrWildColor getDomesticOrWildAnimalColor(int id) {
        DomesticOrWildColor domesticOrWildColor = new DomesticOrWildColor();

        try(SqlSession session = factory.openSession()) {
            HashMap colorResults =
                session.selectOne("DomesticOrWildAnimalColorMapper.xml.selectDomesticOrWildAnimalColor", id);
            domesticOrWildColor.setColorID((Integer) colorResults.get("ID"));
            domesticOrWildColor.setColor((String) colorResults.get("Color"));
            domesticOrWildColor.setShade((String) colorResults.get("Shade"));

        }

        return domesticOrWildColor;
    }

    public void updateDomesticOrWildAnimalColor(int id) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticOrWildAnimalColorMapper.xml.updateDomesticOrWildAnimalColor");
        }
    }
    public void deleteDomesticOrWildAnimalColor(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalColorMapper.xml.deleteDomesticOrWildAnimalColor", id);
        }
    }
}
