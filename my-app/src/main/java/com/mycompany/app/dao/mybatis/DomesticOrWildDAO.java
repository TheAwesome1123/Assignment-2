package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.DomesticOrWild;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DomesticOrWildDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildDAO.class);

    public void createDomesticOrWildAnimal(String type, boolean isDomesticated, String name, int ownerID, int animalID) {
        try(SqlSession session = factory.openSession()) {
            session.insert("DomesticOrWildAnimalMapper.xml.insertDomesticOrWildAnimal");
        }
    }

    public DomesticOrWild getDomesticOrWildAnimal(int id) {
        DomesticOrWild domesticatedOrWild = new DomesticOrWild();

        try(SqlSession session = factory.openSession()) {
            HashMap results = session.selectOne("DomesticOrWildAnimalMapper.xml.selectDomesticOrWildAnimal", id);
            domesticatedOrWild.setDomesticOrWildID((Integer) results.get("ID"));
            domesticatedOrWild.setDomesticOrWildType((String) results.get("Type"));
            domesticatedOrWild.setDomesticated((Boolean) results.get("IsDomesticated"));
            domesticatedOrWild.setAnimalID((Integer) results.get("Animal_ID"));
        }

        return domesticatedOrWild;
    }

    public void updateDomesticOrWildAnimal(int id, String isDomesticated) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticOrWildAnimalMapper.xml.updateDomesticOrWildAnimal");
        }
    }

    public void deleteDomesticOrWildAnimal(int id) {
        try(SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalMapper.xml.deleteDomesticOrWildAnimal", id);
        }
    }
}
