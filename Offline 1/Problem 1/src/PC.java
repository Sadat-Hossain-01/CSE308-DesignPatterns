import java.util.ArrayList;

public class PC {
    private int totalPrice = 70000; // base price
    private ArrayList<Component> components;

    public void addComponent(Component c) {
        components.add(c);
        totalPrice += c.componentPrice;
    }


    public void showPCDetails() {
        int i = 1;
        for (Component c : components) {
            System.out.println(i + ". " + c.type + ": " + c.componentPrice);
        }
    }
}
