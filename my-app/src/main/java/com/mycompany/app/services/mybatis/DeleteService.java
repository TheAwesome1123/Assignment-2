package com.mycompany.app.services.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeleteService {
    private static SqlSessionFactory factory = SqlSessionFactoryGetter.getFactory();

    public static void deleteAnimal(int animalID) {
        try(SqlSession session = factory.openSession()) {
            session.update("PetMapper.xml.updateAnimalForeignKey", animalID);
            session.update("WildAnimalMapper.xml.updateAnimalForeignKey", animalID);
            session.update("DomesticOrWildAnimalMapper.xml.updateAnimalForeignKey", animalID);
            session.delete("AnimalMapper.xml.deleteAnimal", animalID);
            session.commit();
        }
    }

    public static void deletePet(int petID) {
        try(SqlSession session = factory.openSession()) {
            session.update("CatMapper.xml.updatePetForeignKey", petID);
            session.update("DogMapper.xml.updatePetForeignKey", petID);
            session.delete("PetMapper.xml.deletePet", petID);
            session.commit();
        }
    }

    public static void deleteCat(int catID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("CatMapper.xml.deleteCat", catID);
            session.commit();
        }
    }

    public static void deleteDog(int dogID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("CatMapper.xml.deleteDog", dogID);
            session.commit();
        }
    }

    public static void deleteOwner(int ownerID) {
        try(SqlSession session = factory.openSession()) {
            session.update("PetMapper.xml.updateOwnerForeignKey", ownerID);
            session.delete("OwnerMapper.xml.deleteOwner", ownerID);
            session.commit();
        }
    }

    public static void deleteWildAnimal(int wildAnimalID) {
        try(SqlSession session = factory.openSession()) {
            session.update("HomeContinentMapper.xml.updateWildAnimalForeignKey", wildAnimalID);
            session.update("WildAnimalsAndColorsMapper.xml.updateWildAnimalForeignKey",
                wildAnimalID);
            session.delete("WildAnimalMapper.xml.deleteWildAnimal", wildAnimalID);
            session.commit();
        }
    }

    public static void deleteHomeContinent(int continentID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("HomeContinentMapper.xml.deleteHomeContinent", continentID);
            session.commit();
        }
    }

    public static void deleteWildAnimalColor(int colorID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("WildAnimalColorMapper.xml.deleteWildAnimalColor", colorID);
            session.commit();
        }
    }

    public static void deleteWildAnimalAndColorRelation(int relationID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("WildAnimalsAndColorsMapper.xml.deleteWildAnimalsAndColors", relationID);
            session.commit();
        }
    }

    public static void deleteDomesticOrWildAnimal(int domesticOrWildAnimalID) {
        try(SqlSession session = factory.openSession()) {
            session.update("DomesticOrWildAnimalsAndColorsMapper.xml.updateDomesticOrWildAnimalForeignKey",
                domesticOrWildAnimalID);
            session.update("DomesticAnimalMapper.xml.updateDomesticOrWildAnimalForeignKey", domesticOrWildAnimalID);
            session.delete("DomesticOrWildAnimalMapper.xml.deleteDomesticOrWildAnimal", domesticOrWildAnimalID);
            session.commit();
        }
    }

    public static void deleteDomesticAnimal(int domesticAnimalID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("DomesticAnimalMapper.xml.deleteDomesticAnimal", domesticAnimalID);
            session.commit();
        }
    }

    public static void deleteDomesticOrWildAnimalColor(int colorID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalColorMapper.xml.deleteDomesticOrWildAnimalColor", colorID);
            session.commit();
        }
    }

    public static void deleteDomesticOrWildAnimalAndColorRelation(int relationID) {
        try(SqlSession session = factory.openSession()) {
            session.delete("DomesticOrWildAnimalsAndColorsMapper.xml.deleteDomesticOrWildAnimalsAndColors",
                relationID);
            session.commit();
        }
    }
}
