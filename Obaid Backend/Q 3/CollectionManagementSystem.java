import java.util.*;

public class CollectionManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<String> list = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Collection Management System ---");
            System.out.println("1. Manage List");
            System.out.println("2. Manage Set");
            System.out.println("3. Manage Map");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageList();
                    break;
                case 2:
                    manageSet();
                    break;
                case 3:
                    manageMap();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    // --------------------- LIST ---------------------
    public static void manageList() {
        int choice;
        do {
            System.out.println("\n--- Manage List ---");
            System.out.println("1. Add Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Display All Elements");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    String toAdd = scanner.nextLine();
                    list.add(toAdd);
                    System.out.println("Added: " + toAdd);
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    String toRemove = scanner.nextLine();
                    if (list.remove(toRemove)) {
                        System.out.println("Removed: " + toRemove);
                    } else {
                        System.out.println("Error: Element not found in list.");
                    }
                    break;
                case 3:
                    System.out.println("List Elements: " + list);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    // --------------------- SET ---------------------
    public static void manageSet() {
        int choice;
        do {
            System.out.println("\n--- Manage Set ---");
            System.out.println("1. Add Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Display All Elements");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    String element = scanner.nextLine();
                    if (set.add(element)) {
                        System.out.println("Added: " + element);
                    } else {
                        System.out.println("Error: Duplicate element, not added.");
                    }
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    String removeElement = scanner.nextLine();
                    if (set.remove(removeElement)) {
                        System.out.println("Removed: " + removeElement);
                    } else {
                        System.out.println("Error: Element not found in set.");
                    }
                    break;
                case 3:
                    System.out.println("Set Elements: " + set);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    // --------------------- MAP ---------------------
    public static void manageMap() {
        int choice;
        do {
            System.out.println("\n--- Manage Map ---");
            System.out.println("1. Add Key-Value Pair");
            System.out.println("2. Remove Key");
            System.out.println("3. Display All Pairs");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    if (map.containsKey(key)) {
                        System.out.println("Error: Duplicate key. Key already exists.");
                    } else {
                        System.out.print("Enter value: ");
                        String value = scanner.nextLine();
                        map.put(key, value);
                        System.out.println("Added: (" + key + ", " + value + ")");
                    }
                    break;
                case 2:
                    System.out.print("Enter key to remove: ");
                    String removeKey = scanner.nextLine();
                    if (map.containsKey(removeKey)) {
                        map.remove(removeKey);
                        System.out.println("Removed key: " + removeKey);
                    } else {
                        System.out.println("Error: Key not found.");
                    }
                    break;
                case 3:
                    System.out.println("Map Elements: " + map);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
