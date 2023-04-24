public class Elephant extends WildAnimal implements AnimalActions, WildAnimalBehaviors {
    // Properties.
    private int heightInFeet;
    private String sex;

    // Constructor.
    public Elephant(String homeContinent, String color, int heightInFeet, String sex) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.heightInFeet = heightInFeet;
        this.sex = sex;
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
    
    public int getHeightInFeet() {
        return this.heightInFeet;
    }

    public void setHeightInFeet(int newHeight) {
        this.heightInFeet = newHeight;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String newSex) {
        this.sex = newSex;
    }

    // Other methods.
    public String toString() {
        return "Elephant Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Height in feet: " + this.heightInFeet + 
            ", Sex: " + this.sex;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.heightInFeet;
        return result;
    }

    public void eat() {
        System.out.println("An elephant that is " + this.heightInFeet + " feet tall is eating.");
    }

    public void makeNoise() {
        System.out.println("An elephant that is " + this.heightInFeet + " feet tall is trumpeting.");
    }

    public void hunt() {
        System.out.println("An elephant that is " + this.heightInFeet + " feet tall is looking for food.");
    }

    public void mate() {
        System.out.println("An elephant that is " + this.heightInFeet + " feet tall is mating.");

    }
}