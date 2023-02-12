import java.util.ArrayList;
import java.util.List;

public class Company implements Component {
    private String name;
    private List<Manager> managers = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void showHierarchy(int depth) {
        System.out.println("- " + name);
        for (Manager c : managers) {
            c.showHierarchy(depth + 1);
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Company Name: " + name);
        System.out.println("Number of Running Projects: " + managers.size());
    }

    @Override
    public void removeChild(Component c) {
        managers.remove(c);
    }

    public void delete() {
        for (Manager m : managers) {
            m.recursiveDelete(); // delete all children (and their children)
        }
        managers.clear();
        System.out.println("Company " + name + " has been deleted.");
    }

    @Override
    public void addChild(Component c) {
        managers.add((Manager) c);
    }

}
