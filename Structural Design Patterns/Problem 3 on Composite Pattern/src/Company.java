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
        for (Component c : managers) {
            c.showHierarchy(depth + 1);
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Company Name: " + name);
        System.out.println("Number of Projects: " + managers.size());
    }

    @Override
    public void removeChild(Component c) {
        managers.remove(c);
    }

    public void delete() {
        for (Manager m : managers) {
            m.recursiveDelete();
        }
        managers.clear();
        System.out.println("Company " + name + " has been deleted.");
    }

    @Override
    public void addChild(Component c) {
        managers.add((Manager) c);
        // new manager, new project
    }

}
