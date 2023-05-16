package com.mycompany.app.reflection;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.animals.Dog;
import com.mycompany.app.enums.DogBreed;
import com.mycompany.app.enums.Sex;
import org.apache.logging.log4j.*;

import java.lang.reflect.*;

public class ReflectionMain {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionMain.class);
    public static void main(String[] args) {
        Animal testAnimal = new Dog("Sam", DogBreed.GERMANSHEPHERD, Sex.MALE, 5, "Robert",
                false);

        Field[] fields = testAnimal.getClass().getDeclaredFields();
        Constructor[] constructors = testAnimal.getClass().getDeclaredConstructors();
        Method[] methods = testAnimal.getClass().getDeclaredMethods();

        // Instance vars.
        for(Field field: fields) {
            LOGGER.info("Field: " + field.getName() + ", Modifier(s): " +
                Modifier.toString(field.getModifiers()));
        }

        LOGGER.info("");

        // Constructor(s).
        for(Constructor constructor: constructors) {
            LOGGER.info("Constructor parameter types: ");
            Type[] parameterTypes = constructor.getParameterTypes();

            for(Type t: parameterTypes) {
                LOGGER.info(t.getTypeName());
            }
        }

        LOGGER.info("");

        // Methods.
        for(Method method: methods) {
            LOGGER.info("Method name: " + method.getName()+ ", Return Type: " + method.getReturnType().getName());
        }
    }
}
