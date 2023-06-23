package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.WildAnimalColor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class WildAnimalColorDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalColorDAO.class);

    public void createWildAnimalColor(String color, String shade) {
        try(SqlSession session = factory.openSession()) {
            WildAnimalColor wildAnimalColor = new WildAnimalColor();
            wildAnimalColor.setShade(shade);
            wildAnimalColor.setColor(color);

            session.insert("WildAnimalColorMapper.xml.insertWildAnimalColor", wildAnimalColor);
            session.commit();
        }
    }

    public WildAnimalColor getWildAnimalColor(int id) {
        WildAnimalColor wildAnimalColor = new WildAnimalColor();

        try(SqlSession session = factory.openSession()) {
            HashMap colorResults = session.selectOne("WildAnimalColorMapper.xml.selectWildAnimalColor", id);
            wildAnimalColor.setColorID((Integer) colorResults.get("ID"));
            wildAnimalColor.setColor((String) colorResults.get("Color"));
            wildAnimalColor.setShade((String) colorResults.get("Shade"));
            session.commit();
        }

        return wildAnimalColor;
    }

    public void updateWildAnimalColor(WildAnimalColor wildAnimalColor) {
        try(SqlSession session = factory.openSession()) {
            session.update("WildAnimalColorMapper.xml.updateWildAnimalColor", wildAnimalColor);
            session.commit();
        }
    }
    public void deleteWildAnimalColor(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("WildAnimalColorMapper.xml.deleteWildAnimalColor", id);
            session.commit();
        }
    }
}
