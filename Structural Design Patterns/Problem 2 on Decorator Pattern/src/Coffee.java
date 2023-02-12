import java.util.ArrayList;
import java.util.List;

public abstract class Coffee {
    protected String name;
    protected List<String> ingredients = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void showDescription() {
        System.out.println(name + ", Cost: " + getCost() + " BDT");
        System.out.println("Ingredients:");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println((i + 1) + ". " + ingredients.get(i));
        }
    }

    public abstract int getCost();
}

class BlackCoffee extends Coffee {
    public BlackCoffee() {
        setName("Black Coffee");
        ingredients.add("Water");
        ingredients.add("Grinded Coffee Beans");
    }

    public int getCost() {
        return 130; // mug + coffee beans = 100 + 30
    }
}

class MilkCoffee extends Coffee {
    public MilkCoffee() {
        setName("Milk Coffee");
        ingredients.add("Milk");
        ingredients.add("Grinded Coffee Beans");
    }

    public int getCost() {
        return 180; // mug + milk + coffee beans = 100 + 50 + 30
    }
}