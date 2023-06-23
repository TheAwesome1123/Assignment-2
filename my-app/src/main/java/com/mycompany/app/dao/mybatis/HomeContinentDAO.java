package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.HomeContinent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class HomeContinentDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(HomeContinentDAO.class);

    public void createHomeContinent(String continent, int wildAnimalID) {
        try(SqlSession session = factory.openSession()) {
            HomeContinent homeContinent = new HomeContinent();
            homeContinent.setContinent(continent);
            homeContinent.setWildAnimalID(wildAnimalID);

            session.insert("HomeContinentMapper.xml.insertHomeContinent", homeContinent);
            session.commit();
        }
    }

    public HomeContinent getHomeContinent(int id) {
        HomeContinent newHomeContinent = new HomeContinent();

        try(SqlSession session = factory.openSession()) {
            HashMap results = session.selectOne("HomeContinentMapper.xml.selectHomeContinent", id);
            newHomeContinent.setContinentID((Integer) results.get("ID"));
            newHomeContinent.setContinent((String) results.get("HomeContinent"));
            newHomeContinent.setWildAnimalID((Integer) results.get("WildAnimal_ID"));
            session.commit();
        }

        return newHomeContinent;
    }

    public void updateHomeContinent(HomeContinent homeContinent) {
        try(SqlSession session = factory.openSession()) {
            session.update("HomeContinentMapper.xml.updateHomeContinent", homeContinent);
            session.commit();
        }
    }
    public void deleteHomeContinent(int id) {
        try(SqlSession session = factory.openSession()) {
            session.delete("HomeContinentMapper.xml.deleteHomeContinent", id);
            session.commit();
        }
    }
}
