import controller.ProjectController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProjectController pc = new ProjectController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a project");
            System.out.println("2. Show all projects");
            System.out.println("3. Update a project");
            System.out.println("4. Delete a project");
            System.out.println("5. Exit");

            System.out.print("Choice (1-5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> pc.createProject();
                case 2 -> pc.showProjects();
                case 3 -> pc.updateProject();
                case 4 -> pc.deleteProject();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid");
            }
        }
    }
}