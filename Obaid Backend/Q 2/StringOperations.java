import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\nString Operations Menu:");
            System.out.println("1. Extract Substring");
            System.out.println("2. Split a Sentence");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.nextLine(); // consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String str = scanner.nextLine();

                    System.out.print("Enter starting index: ");
                    int start = scanner.nextInt();

                    System.out.print("Enter ending index: ");
                    int end = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    if (start >= 0 && end <= str.length() && start < end) {
                        String sub = str.substring(start, end);
                        System.out.println("Extracted substring: " + sub);
                    } else {
                        System.out.println("Invalid indices! Make sure 0 ≤ start < end ≤ string length.");
                    }
                    break;

                case 2:
                    System.out.print("Enter a sentence: ");
                    String sentence = scanner.nextLine();
                    String[] words = sentence.split("\\s+");

                    System.out.println("Words in the sentence:");
                    for (String word : words) {
                        System.out.println(word);
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    continueProgram = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select option 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
