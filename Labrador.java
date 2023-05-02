import org.apache.logging.log4j.*;

public final class Labrador extends Dog {
    // Properties.
    private String color;

    public Labrador(String name, String breed, int age, String owner, boolean fightsWithCats, String color, Logger logger) {
        super(name, breed, age, owner, fightsWithCats, logger);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }
}
