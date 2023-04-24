public class Horse extends DomesticatedOrWild implements HorseActions {
    // Properties.

    // Constructors.
    public Horse(boolean isDomesticated, String name, String breed, int age, String owner) {
        this.isDomesticated = isDomesticated;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;

        if(!this.isDomesticated) {
            this.name = "N/A";
            this.owner = "N/A";
        }
    }

    // Getters/setters.
    public boolean getisDomesticated() {
        return this.isDomesticated;
    }

    public void setisDomesticated(boolean isDomesticatedNow, String owner) {
        this.isDomesticated = isDomesticatedNow;

        if(!this.isDomesticated && !this.owner.equals("N/A")) {
            this.owner = "N/A";
        }
        else if(this.isDomesticated && this.owner.equals("N/A")) {
            this.owner = owner;
        }
    }

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
        
        if(!this.isDomesticated && !newOwner.equals("N/A")) {
            this.isDomesticated = true;
        }
        else if(this.isDomesticated && newOwner.equals("N/A")) {
            this.isDomesticated = false;
        }
    }

    public String toString() {
        return "Horse Is Domesticated: " + this.isDomesticated + ", Name: " + this.name + ", Breed: " + this.breed + ", Age: " + 
        this.age + ", Owner/Rider: " + this.owner;
    }

    public boolean equals(Horse horseToCompareWith) {
        if(this.isDomesticated == horseToCompareWith.isDomesticated && this.name.equals(horseToCompareWith.name) && 
            this.breed.equals(horseToCompareWith.breed) && this.age == horseToCompareWith.age && 
            this.owner.equals(horseToCompareWith.owner)) {
                return true;
        }
        else {
            return false;
        }
    }

    public int hashCode() {
        int result = 1000;
        result *= this.owner.hashCode();
        result += this.age;
        return result;
    }

    public void jump() {
        System.out.println("A " + this.breed + " horse is jumping over a fence.");
    }
}