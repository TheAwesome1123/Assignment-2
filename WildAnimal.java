public abstract class WildAnimal extends Animal implements WildAnimalBehaviors {
    protected String homeContinent;
    protected String color;

    public final void printStatement() {
        System.out.println("Wild animals are not pets.");
    }

    public void lookForFood(String food) throws InvalidFoodException {
        if(food.length() < 4) {
            throw new InvalidFoodException("Invalid food.");
        }
    }

}
