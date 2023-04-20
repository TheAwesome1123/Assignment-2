package domesticatedOrWild;

public class Bird extends DomesticatedOrWild{
    // Properties.

    // Constructors.
    public Bird(boolean isDomesticated, String name, String breed, int age, String owner) {
        this.isDomesticated = isDomesticated;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;

        if(!this.isDomesticated) {
            this.name = "Unknown";
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
        return "Bird Is Domesticated: " + this.isDomesticated + ", Name: " + this.name + ", Breed: " + this.breed + ", Age: " + 
        this.age + ", Owner: " + this.owner;
    }

    public boolean equals(Bird birdToCompareWith) {
        if(this.isDomesticated == birdToCompareWith.isDomesticated && this.name.equals(birdToCompareWith.name) && 
            this.breed.equals(birdToCompareWith.breed) && this.age == birdToCompareWith.age && 
            this.owner.equals(birdToCompareWith.owner)) {
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
}