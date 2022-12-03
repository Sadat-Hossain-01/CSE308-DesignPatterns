import java.util.ArrayList;

public class PC {
    private int totalPrice = 70000; // base price
    private ArrayList<Component> components;

    public PC() {
        components = new ArrayList<>();
    }

    public void addComponent(Component c) {
        components.add(c);
        totalPrice += c.componentPrice;
    }

    public void showPCDetails() {
        int i = 1;
        for (Component c : components) {
            if (i == 1) System.out.println("Base Components: 70000 BDT");
            else if (i == 3) System.out.println("Added Components: " + (totalPrice - 70000) + " BDT");
            if (i <= 2)
                System.out.println(i + ". " + c.type);
            else
                System.out.println((i - 2) + ". " + c.type + ": " + c.componentPrice + " BDT");
            i++;
        }
        System.out.println("Total Price: " + totalPrice + " BDT");
    }
}
