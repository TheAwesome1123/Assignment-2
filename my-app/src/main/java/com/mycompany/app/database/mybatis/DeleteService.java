package com.mycompany.app.database.mybatis;

import com.mycompany.app.models.Pet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeleteService {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();

    private static void deleteAnimal(int animalID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("AnimalMapper.xml.deleteAnimal", animalID);
        }

        // Find entries where Animal_ID = animalID and set to null
    }

    private static void deletePet(int petID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("PetMapper.xml.deletePet", petID);
        }
    }

    private static void deleteCat(int catID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("CatMapper.xml.deleteCat", catID);
        }
    }

    private static void deleteDog(int dogID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("CatMapper.xml.deleteDog", dogID);
        }
    }

    public static void deleteOwner(int ownerID, Pet pet) {
        pet.setOwnerID(null);

        try(SqlSession session = factory.openSession()) {
            session.update("PetMapper.xml.updatePet", pet);
            session.delete("OwnerMapper.xml.deleteOwner", ownerID);
            session.commit();
        }
    }

    private static void deleteWildAnimal(int wildAnimalID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("WildAnimalMapper.xml.deleteWildAnimal", wildAnimalID);
        }
    }

    private static void deleteHomeContinent(int continentID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("HomeContinentMapper.xml.deleteHomeContinent", continentID);
        }
    }

    private static void deleteDomesticOrWildAnimal(int domesticOrWildAnimalID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalMapper.xml.deleteDomesticOrWildAnimal", domesticOrWildAnimalID);
        }
    }


}
