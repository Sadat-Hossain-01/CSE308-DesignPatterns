import java.util.HashMap;
import java.util.Scanner;

public class Demo {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Company> companies = new HashMap<>();
    private static HashMap<String, Manager> managers = new HashMap<>();
    private static HashMap<String, Developer> developers = new HashMap<>();

    enum entityType {COMPANY, MANAGER, DEVELOPER}

    enum detailType {NAME, DETAIL}

    public static boolean showStuffs(entityType entity, detailType detail) {
        System.out.println();
        HashMap map = null;
        String kind = "";
        if (entity == entityType.COMPANY) {
            kind = "Company";
            map = companies;
        } else if (entity == entityType.MANAGER) {
            kind = "Manager";
            map = managers;
        } else if (entity == entityType.DEVELOPER) {
            kind = "Developer";
            map = developers;
        }
        if (map.size() == 0) {
            System.out.println("There is no " + kind.toLowerCase() + " currently.");
            return false;
        } else {
            System.out.println(kind + " List:");
            System.out.println("--------------------");
        }
        for (Object o : map.keySet()) {
            String name = (String) o;
            if (detail == detailType.DETAIL) {
                Component c = (Component) map.get(name);
                c.showDetails();
                System.out.println();
            } else {
                System.out.println(name);
            }
        }
        System.out.println();
        return true;
    }

    public static void addCompany() {
        // input company name
        System.out.print("Enter Company Name: ");
        String name = scanner.nextLine();
        // first check if any company with the same name exists
        if (companies.containsKey(name)) {
            System.out.println("Company with the same name already exists.");
            return;
        }
        // create a new company
        Company c = new Company(name);
        // add it to the companies list
        companies.put(name, c);
        System.out.println("Company successfully created.");
    }

    public static void addManager() {
        // first check if there are any companies to begin with
        if (companies.size() == 0) {
            System.out.println("There are no companies to add managers to.");
            return;
        }
        // input manager name
        System.out.print("Enter Manager Name: ");
        String name = scanner.nextLine();
        // check if any manager with the same name exists
        if (managers.containsKey(name)) {
            System.out.println("Manager with the same name already exists.");
            return;
        }
        // show the detail of all companies
        showStuffs(entityType.COMPANY, detailType.DETAIL);
        // input company name
        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();
        // check if the company is in the list
        if (!companies.containsKey(companyName)) {
            System.out.println("Company not found.");
            return;
        }
        // input project name
        System.out.print("Enter Project Name: ");
        String projectName = scanner.nextLine();
        // create a new manager
        Manager m = new Manager(companies.get(companyName), name, projectName);
        // add it to the managers list
        managers.put(name, m);
        System.out.println("Manager successfully added.");
    }

    public static void addDeveloper() {
        // first check if there are any managers to begin with
        if (managers.size() == 0) {
            System.out.println("There are no managers to add developers under.");
            return;
        }
        // input developer name
        System.out.print("Enter Developer Name: ");
        String name = scanner.nextLine();
        // check if any developer with the same name exists
        if (developers.containsKey(name)) {
            System.out.println("Developer with the same name already exists.");
            return;
        }
        // show the detail of all managers
        showStuffs(entityType.MANAGER, detailType.DETAIL);
        // input manager name
        System.out.print("Enter Manager Name: ");
        String managerName = scanner.nextLine();
        // check if the manager is in the list
        if (!managers.containsKey(managerName)) {
            System.out.println("Manager not found.");
            return;
        }
        // create a new developer
        Developer d = new Developer(managers.get(managerName), name);
        // add it to the developers list
        developers.put(name, d);
        System.out.println("Developer successfully added.");
    }

    public static Component preProcess(entityType entity) { // returns object (company, manager or developer) of a certain name
        HashMap map = null;
        String kind = "";
        if (entity == entityType.COMPANY) {
            map = companies;
            kind = "Company";
        } else if (entity == entityType.MANAGER) {
            map = managers;
            kind = "Manager";
        } else if (entity == entityType.DEVELOPER) {
            map = developers;
            kind = "Developer";
        }
        if (!showStuffs(entity, detailType.NAME)) return null;
        System.out.print("Enter " + kind + " Name: ");
        String name = scanner.nextLine();
        System.out.println();
        if (!map.containsKey(name)) {
            System.out.println(kind + " not found.");
            return null;
        }
        return (Component) map.get(name);
    }

    public static void removeManagerFromMainList(String managerName) {
        // remove any developer under this manager
        for (Developer d : developers.values()) {
            if (d.getManager().getName().equals(managerName)) {
                developers.remove(d.getName());
            }
        }
        // remove the manager
        managers.remove(managerName);
    }

    public static void removeCompanyFromMainList(String companyName) {
        // remove any manager under this company
        for (Manager m : managers.values()) {
            if (m.getCompany().getName().equals(companyName)) {
                removeManagerFromMainList(m.getName());
            }
        }
        // remove the company
        companies.remove(companyName);
    }

    public static void remove(entityType entity) {
        Component c = preProcess(entity);
        if (c == null) return;
        if (entity == entityType.COMPANY) {
            String companyName = ((Company) c).getName();
            removeCompanyFromMainList(companyName);
        } else if (entity == entityType.MANAGER) {
            String managerName = ((Manager) c).getName();
            removeManagerFromMainList(managerName);
        } else if (entity == entityType.DEVELOPER) {
            String developerName = ((Developer) c).getName();
            developers.remove(developerName);
        }
        c.delete();
        System.out.println("Successfully removed.");
    }

    public static void showDetail(entityType entityType) {
        Component c = preProcess(entityType);
        if (c != null) {
            c.showDetails();
        }
    }

    public static void showHierarchy(entityType entityType) {
        Component c = preProcess(entityType);
        if (c != null) {
            c.showHierarchy();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Control Hub!");
        while (true) {
            System.out.println();
            System.out.println("1. Add Company");
            System.out.println("2. Add Manager");
            System.out.println("3. Add Developer");
            System.out.println("4. Remove Company");
            System.out.println("5. Remove Manager");
            System.out.println("6. Remove Developer");
            System.out.println("7. Show Company Details");
            System.out.println("8. Show Manager Details");
            System.out.println("9. Show Developer Details");
            System.out.println("10. Show Company Hierarchy");
            System.out.println("11. Show Manager Hierarchy");
            System.out.println("12. Show Developer Hierarchy");
            System.out.println("13. Exit");
            System.out.print("\nEnter Your Choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input.");
                scanner.nextLine();
                continue;
            }
            System.out.println();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    addManager();
                    break;
                case 3:
                    addDeveloper();
                    break;
                case 4:
                    remove(entityType.COMPANY);
                    break;
                case 5:
                    remove(entityType.MANAGER);
                    break;
                case 6:
                    remove(entityType.DEVELOPER);
                    break;
                case 7:
                    showDetail(entityType.COMPANY);
                    break;
                case 8:
                    showDetail(entityType.MANAGER);
                    break;
                case 9:
                    showDetail(entityType.DEVELOPER);
                    break;
                case 10:
                    showHierarchy(entityType.COMPANY);
                    break;
                case 11:
                    showHierarchy(entityType.MANAGER);
                    break;
                case 12:
                    showHierarchy(entityType.DEVELOPER);
                    break;
                case 13:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
