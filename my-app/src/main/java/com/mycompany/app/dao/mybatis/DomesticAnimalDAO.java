package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.DomesticAnimal;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DomesticAnimalDAO {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DomesticAnimalDAO.class);

    public void createDomesticAnimal(String name, int ownerID, int domesticOrWildAnimalID) {
        try(SqlSession session = factory.openSession()) {
            session.insert("DomesticAnimalMapper.xml.createDomesticAnimal");
        }
    }

    public DomesticAnimal getDomesticAnimal(int id) {
        DomesticAnimal domesticAnimal = new DomesticAnimal();

        try(SqlSession session = factory.openSession()) {
            HashMap domesticAnimalResults = session.selectOne("DomesticAnimalMapper.xml.selectDomesticAnimal");
            domesticAnimal.setDomesticAnimalID((Integer) domesticAnimalResults.get("ID"));
            domesticAnimal.setName((String) domesticAnimalResults.get("Name"));
            domesticAnimal.setOwnerID((Integer) domesticAnimalResults.get("Owner_ID"));
            domesticAnimal.setDomesticOrWildID((Integer) domesticAnimalResults.get("DomesticOrWild_ID"));
        }

        return domesticAnimal;
    }
    public void updateDomesticAnimal(int id) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticAnimalMapper.xml.updateDomesticAnimal");
        }
    }
    public void deleteDomesticAnimal(int id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("DomesticAnimalMapper.xml.deleteDomesticAnimal", id);
        }
    }
}
