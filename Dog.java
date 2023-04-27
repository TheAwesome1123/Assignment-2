public class Dog extends Pet {
    // Properties.
    private boolean fightsWithCats;
    private static int numOfLegs = 4;

    // Constructor.
    public Dog(String name, String breed, int age, String owner, boolean fightsWithCats) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        this.fightsWithCats = fightsWithCats;
    }

    // Getters/setters.
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    public boolean getFightingWithCatsHabit() {
        return this.fightsWithCats;
    }

    public void setFightingWithCatsHabit(boolean habit) {
        this.fightsWithCats = habit;
    }

    public static int getNumOfLegs() {
        return numOfLegs;
    }

    // Other methods.
    public void adopt() {
        System.out.println("A " + this.breed + " dog named " + this.name + " was adopted by " + this.owner + ".");
    }

    public String toString() {
        return "Dog Name: " + this.name + ", Breed: " + this.breed + ", Age: " + this.age + ", Owner: " + this.owner + 
        ", Fights with cats:" + this.fightsWithCats;
    }

    public boolean equals(Dog dogToCompareWith) {
        if(this.name.equals(dogToCompareWith.name) && this.breed.equals(dogToCompareWith.breed) && 
            this.age == dogToCompareWith.age && this.owner.equals(dogToCompareWith.owner) && 
            this.fightsWithCats == dogToCompareWith.fightsWithCats) {
                return true;
        }
        else {
            return false;
        }
    }

    public int hashCode() {
        int result = 1000;
        result *= this.name.hashCode();
        result += this.age;
        return result;
    }

    public void eat() {
        System.out.println("A " + this.breed + " dog named " + this.name + " is eating.");
    }

    public void makeNoise(String noise) throws InvalidSoundException {
        super.makeNoise(noise);
        System.out.println("A " + this.breed + " dog named " + this.name + " is making a " + noise + " sound.");
    }

    public void pet() {
        System.out.println(this.owner + " is petting a " + this.breed + " dog named " + this.name + ".");
    }
}