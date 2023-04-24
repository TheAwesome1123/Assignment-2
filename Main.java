public class Main {
    static {
        System.out.println("Order of operations:");
        System.out.println("1. Create animal objects (not shown here).");
        System.out.println("2. Use methods in animal classes.");
        System.out.println("3. Use interface methods.");
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        // New objects.
        Bear bear = new Bear("North America", "brown", "Brown", 2);
        Bird bird = new Bird(true, "Jack", "Parrot", 3, "Robert");
        Bird eagle = new Bird(false, "Unknown", "Bald Eagle", 4, "Robert");
        Cat cat = new Cat("Bob", "American Shorthair", 3, "Robert");
        Cat cat2 = new Cat("Bob", "American Shorthair", 3, "Robert");
        Dog germanShepherd = new Dog("Sam", "German Shepherd", 5, "Robert", false);
        Elephant elephant = new Elephant("Africa", "gray", 10, "Male");
        Horse horse = new Horse(true, "Bob", "American Belgian Draft", 5, "Robert");
        Rabbit rabbit = new Rabbit("Jerry", "American", 3, "Robert");
        Rhino rhino = new Rhino ("Africa", "gray", 1000);
        Rhino rhino2 = new Rhino ("Africa", "grey", 1000);
        Squirrel squirrel = new Squirrel("North America", "light brown", 1);
        Wolf wolf = new Wolf("North America", "light gray", 5);

        // Pets.
        doPetStuff(cat, cat2, germanShepherd, rabbit);
        System.out.println("-----------------");


        // Wild animals.
        doWildAnimalStuff(bear, elephant, rhino, rhino2, squirrel, wolf);
        System.out.println("-----------------");


        // Domestic or wild animals.
        doDomesticOrWildAnimalStuff(bird, eagle, horse);
        System.out.println("-----------------");

        // Interface methods.
        interfaceMethods(cat2, germanShepherd, bird, horse, elephant, wolf);
    }

    public static void doPetStuff(Cat cat, Cat cat2, Dog dog, Rabbit rabbit) {
        cat.adopt();
        dog.adopt();
        rabbit.adopt();
        System.out.println();
        System.out.println("Is \"" + cat.toString() + "\" the same as \"" + cat.toString() + "\" ? " + cat.equals(cat2) + "\n");
        System.out.println("Dog hash code: " + dog.hashCode() + "\n");
        System.out.println(rabbit.toString() + "\n");
    }

    public static void doWildAnimalStuff(Bear bear, Elephant elephant, Rhino rhino, Rhino rhino2, Squirrel squirrel, Wolf wolf) {
        System.out.println(bear.toString());
        bear.setNumCubs(6);
        System.out.println(bear.toString() + "\n");
        System.out.println("ELephant hash code: " + elephant.hashCode());
        elephant.eat();
        System.out.println();
        System.out.println("Is \"" + rhino.toString() + "\" the same as \"" + rhino2.toString() + "\" ? " + rhino.equals(rhino2) + "\n");
        System.out.println(squirrel.toString() + "\n");
        wolf.eat();
        System.out.println();
    }

    public static void doDomesticOrWildAnimalStuff(Bird bird, Bird bird2, Horse horse) {
        System.out.println(bird.toString());
        System.out.println("Bird hash code: " + bird.hashCode());
        bird.setOwner("N/A");
        System.out.println(bird.toString());
        System.out.println(bird2.toString()+ "\n");
        System.out.println(horse.toString());
        horse.setisDomesticated(false, "Robert");
        System.out.println(horse.toString());
    }

    public static void interfaceMethods(Cat cat, Dog dog, Bird bird, Horse horse, Elephant elephant, Wolf wolf) {
        cat.eat();
        dog.teach("fetch");
        bird.fly();
        horse.jump();
        elephant.makeNoise();
        wolf.hunt();
    }
}