package com.mycompany.app.json;

import com.mycompany.app.json.cat.CatParser;
import com.mycompany.app.json.domesticanimal.DomesticAnimalParser;
import com.mycompany.app.json.owner.OwnerParser;
import com.mycompany.app.json.wildanimalcolor.WildAnimalColorParser;
import com.mycompany.app.json.wildanimalsandcolors.WildAnimalsAndColorsParser;
import com.mycompany.app.models.WildAnimalColor;
import com.mycompany.app.xml.XMLMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JSONMain {
    private static File catFile, domesticAnimalFile, ownerFile, wildAnimalsAndColorsFile, wildAnimalColorFile;
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    public static void main(String[] args) {
        catFile = new File("my-app/src/main/java/com/mycompany/app/json/cat/Cat.json");
        domesticAnimalFile = new File(
        "my-app/src/main/java/com/mycompany/app/json/domesticanimal/DomesticAnimal.json");
        ownerFile = new File("my-app/src/main/java/com/mycompany/app/json/owner/Owner.json");
        wildAnimalsAndColorsFile = new File (
        "my-app/src/main/java/com/mycompany/app/json/wildanimalsandcolors/WildAnimalsAndColors.json");
        wildAnimalColorFile = new File(
        "my-app/src/main/java/com/mycompany/app/json/wildanimalcolor/WildAnimalColor.json");

        CatParser.parse();
        DomesticAnimalParser.parse();
        WildAnimalColorParser.parse();
        OwnerParser.parse();
        WildAnimalsAndColorsParser.parse();
    }

    public static String getCatFile() {
        return catFile.toString();
    }

    public static String getDomesticAnimalFile() {
        return domesticAnimalFile.toString();
    }

    public static String getOwnerFile() {
        return ownerFile.toString();
    }

    public static String getWildAnimalsAndColorsFile() {
        return wildAnimalsAndColorsFile.toString();
    }

    public static String getWildAnimalColorFile() {
        return wildAnimalColorFile.toString();
    }
}
