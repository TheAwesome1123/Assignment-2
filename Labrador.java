public final class Labrador extends Dog {
    // Properties.
    private String color;

    public Labrador(String name, String breed, int age, String owner, boolean fightsWithCats, String color) {
        super(name, breed, age, owner, fightsWithCats);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }
}
