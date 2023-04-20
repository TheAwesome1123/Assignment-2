package pets;

public abstract class Pet {
    protected String name;
    protected String breed;
    protected int age;
    protected String owner;

    protected abstract void adopt();
}
