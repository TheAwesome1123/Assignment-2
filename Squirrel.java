public class Squirrel extends WildAnimal {
    // Properties.
    private int numOfVisitsToHousePerDay;

    // Constructor.
    public Squirrel(String homeContinent, String color, int numOfVisitsToHousePerDay) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.numOfVisitsToHousePerDay = numOfVisitsToHousePerDay;
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

    public int getnumOfVisitsToHousePerDay() {
        return this.numOfVisitsToHousePerDay;
    }

    public void setnumOfVisitsToHousePerDay(int newNumOfVisits) {
        this.numOfVisitsToHousePerDay = newNumOfVisits;
    }

    // Other methods.
    public String toString() {
        return "Squirrel Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Number of Visits to a House per Day: " + 
            this.numOfVisitsToHousePerDay;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.numOfVisitsToHousePerDay;
        return result;
    }

    public void eat() {
        System.out.println("A " + this.color + " squirrel is eating nuts.");
    }

    public void makeNoise(String noise) throws InvalidSoundException {
        super.makeNoise(noise);
        System.out.println("A " + this.color + " squirrel is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws InvalidFoodException {
        super.lookForFood(food);
        System.out.println("A " + this.color + " squirrel is looking for ." + food + ".");
    }

    public void mate() {
        System.out.println("A " + this.color + " squirrel is mating.");
    }
}