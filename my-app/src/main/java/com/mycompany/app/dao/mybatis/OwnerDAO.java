package com.mycompany.app.dao.mybatis;

import com.mycompany.app.database.mybatis.SqlSessionFactoryGetter;
import com.mycompany.app.models.designpattern.ModelFactory;

import com.mycompany.app.models.Owner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class OwnerDAO {
    private static final ModelFactory modelFactory = ModelFactory.getModelFactory();
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(OwnerDAO.class);

    public void createOwner(String firstName, String lastName) {
        try(SqlSession session = factory.openSession()) {
            Owner owner = (Owner) modelFactory.createModel("Owner");
            owner.setFirstName(firstName);
            owner.setLastName(lastName);

            session.insert("OwnerMapper.xml.insertOwner", owner);
            session.commit();
        }
    }

    public Owner getOwner(int id) {
        Owner owner = (Owner) modelFactory.createModel("Owner");

        try(SqlSession session = factory.openSession()) {
            HashMap ownerResults = session.selectOne("OwnerMapper.xml.selectOwner", id);
            owner.setOwnerID((Integer) ownerResults.get("ID"));
            owner.setFirstName((String) ownerResults.get("First_Name"));
            owner.setLastName((String) ownerResults.get("Last_Name"));

            if(ownerResults.get("Height") != null) {
                owner.setHeight((Double) ownerResults.get("Height"));
            }

            session.commit();
        }

        return owner;
    }

    public void updateOwner(Owner owner) {
        try(SqlSession session = factory.openSession()) {
            session.update("OwnerMapper.xml.updateOwner", owner);
            session.commit();
        }
    }

    private static void deleteOwner(int ownerID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("OwnerMapper.xml.deleteOwner", ownerID);
            session.commit();
        }
    }
}
