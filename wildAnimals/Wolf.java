package wildAnimals;

public class Wolf extends WildAnimal{
    // Properties.
    private int packSize;

    // Constructor.
    public Wolf(String homeContinent, String color, int packSize) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.packSize = packSize;
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

    public int getPackSize() {
        return this.packSize;
    }

    public void setPackSize(int newSize) {
        this.packSize = newSize;
    }

    // Other methods.
    public void eat() {
        System.out.println("A " + this.color + " wolf is eating with other wolves in its pack of " + this.packSize + ".");
    }

    public String toString() {
        return "Wolf Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Pack Size: " + this.packSize;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.packSize;
        return result;
    }
}