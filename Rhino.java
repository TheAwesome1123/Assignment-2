public class Rhino extends WildAnimal implements AnimalActions, WildAnimalBehaviors {
    // Properties.
    private int weightInPounds;

    // Constructor.
    public Rhino(String homeContinent, String color, int weightInPounds) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.weightInPounds = weightInPounds;
    }

    // Getters/setters.
    public String getHomeContinent() {
        return this.homeContinent;
    }

    public void setHomeContinent(String newContinent) {
        this.homeContinent = newContinent;
    }
    
    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public int getWeightInPounds() {
        return this.weightInPounds;
    }

    public void setWeightInPounds(int newWeight) {
        this.weightInPounds = newWeight;
    }

    // Other methods.
    public String toString() {
        return "Rhino Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Weight in Pounds: " + this.weightInPounds;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.weightInPounds;
        return result;
    }

    public void eat() {
        System.out.println("A rhino that weighs " + this.weightInPounds + " pounds is eating.");
    }

    public void makeNoise() {
        System.out.println("A rhino that weighs " + this.weightInPounds + " pounds is \"roaring\".");
    }

    public void hunt() {
        System.out.println("A rhino that weighs " + this.weightInPounds + " pounds is looking for plants to eat.");
    }

    public void mate() {
        System.out.println("A rhino that weighs " + this.weightInPounds + " pounds is mating.");

    }
}