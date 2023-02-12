import java.util.ArrayList;
import java.util.List;

public abstract class StuffComponent implements Component {
    protected String name;
    protected Component parent; // will need this for deleting from parent's children list

    enum Role {
        Manager, Developer
    }

    protected Role role;
    protected String projectName;

    public String getName() {
        return name;
    }

    public StuffComponent(String name, Role role, String projectName) {
        this.name = name;
        this.role = role;
        this.projectName = projectName;
    }

    protected void showInitialDetails() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + (role == Role.Manager ? "Project Manager" : "Software Developer"));
        System.out.println("Current Project: " + projectName);
    }

    public abstract void showDetails();

    protected abstract void recursiveDelete();

    public final void delete() {
        recursiveDelete(); // delete all children
        parent.removeChild(this); // remove itself from parent's children list
    }
}

class Manager extends StuffComponent {
    private List<Developer> developers = new ArrayList<>();

    public Manager(Company company, String name, String projectName) {
        super(name, Role.Manager, projectName);
        this.parent = company;
        company.addChild(this);
    }

    @Override
    public void showHierarchy(int depth) {
        for (int i = 0; i < depth; i++) System.out.print("\t");
        System.out.println("- " + name + " (" + projectName + ")");
        for (Developer c : developers) {
            c.showHierarchy(depth + 1);
        }
    }

    @Override
    public void removeChild(Component c) {
        developers.remove(c);
    }

    @Override
    public void recursiveDelete() {
        for (Developer c : developers) {
            c.recursiveDelete();
        }
        developers.clear();
        System.out.println("Manager " + name + " has been removed.");
    }

    @Override
    public void addChild(Component c) {
        developers.add((Developer) c);
    }

    @Override
    public void showDetails() {
        showInitialDetails();
        System.out.println("Number of Supervisees: " + developers.size());
    }

    public Company getCompany() {
        return (Company) parent;
    }
}

class Developer extends StuffComponent {

    public Developer(Manager manager, String name) {
        super(name, Role.Developer, manager.projectName);
        this.parent = manager;
        manager.addChild(this);
    }

    @Override
    public void showHierarchy(int depth) {
        for (int i = 0; i < depth; i++) System.out.print("\t");
        System.out.println("- " + name);
    }

    @Override
    public void removeChild(Component c) {
        throw new UnsupportedOperationException("Developer cannot have supervisee.");
    }

    @Override
    protected void recursiveDelete() {
        System.out.println("Developer " + name + " has been removed.");
    }

    @Override
    public void addChild(Component c) {
        throw new UnsupportedOperationException("Developer cannot have supervisee.");
    }

    @Override
    public void showDetails() {
        showInitialDetails();
    }

    public Manager getManager() {
        return (Manager) parent;
    }
}

