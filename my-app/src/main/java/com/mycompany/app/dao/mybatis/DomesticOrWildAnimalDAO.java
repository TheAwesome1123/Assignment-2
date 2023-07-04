package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.DomesticOrWildAnimal;
import com.mycompany.app.models.designpattern.ModelFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DomesticOrWildAnimalDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildAnimalDAO.class);

    public void createDomesticOrWildAnimal(String type, boolean isDomesticated, int animalID) {
        try(SqlSession session = factory.openSession()) {
            DomesticOrWildAnimal domesticOrWildAnimal =
                (DomesticOrWildAnimal) modelFactory.createModel("DomesticOrWildAnimal");
            domesticOrWildAnimal.setDomesticOrWildType(type);
            domesticOrWildAnimal.setDomesticated(isDomesticated);

            domesticOrWildAnimal.setAnimalID(animalID);

            session.insert("DomesticOrWildAnimalMapper.xml.insertDomesticOrWildAnimal", domesticOrWildAnimal);
            session.commit();
        }
    }

    public DomesticOrWildAnimal getDomesticOrWildAnimal(int id) {
        DomesticOrWildAnimal domesticatedOrWild =
            (DomesticOrWildAnimal) modelFactory.createModel("DomesticOrWildAnimal");

        try(SqlSession session = factory.openSession()) {
            HashMap results = session.selectOne("DomesticOrWildAnimalMapper.xml.selectDomesticOrWildAnimal", id);
            domesticatedOrWild.setDomesticOrWildID((Integer) results.get("ID"));
            domesticatedOrWild.setDomesticOrWildType((String) results.get("Type"));
            domesticatedOrWild.setDomesticated((Boolean) results.get("IsDomesticated"));
            domesticatedOrWild.setAnimalID((Integer) results.get("Animal_ID"));
            session.commit();
        }

        return domesticatedOrWild;
    }

    public void updateDomesticOrWildAnimal(DomesticOrWildAnimal domesticOrWildAnimal) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticOrWildAnimalMapper.xml.updateDomesticOrWildAnimal", domesticOrWildAnimal);
            session.commit();
        }
    }

    public void deleteDomesticOrWildAnimal(int id) {
        try(SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalMapper.xml.deleteDomesticOrWildAnimal", id);
            session.commit();
        }
    }
}
