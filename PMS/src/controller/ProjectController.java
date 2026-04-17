package controller;
import model.Project;
import java.util.Scanner;

public class ProjectController {
    Project[] db = new Project[200];
    int count = 0;
    Scanner input = new Scanner(System.in);

    //    Create
    public void createProject() {
        db[count] = new Project();

        System.out.println("           CREATE NEW PROJECT");
        System.out.println("====================================\n");

        int id;
        boolean isDuplicate;

        do {
            isDuplicate = false;

            System.out.print("Enter Project ID (unique): ");
            id = input.nextInt();
            input.nextLine();

            for (int i = 0; i < count; i++) {
                if (db[i].id == id) {
                    System.out.println("This ID is already used. Enter a unique ID!");
                    isDuplicate = true;
                    break;
                }
            }

        } while (isDuplicate);

        db[count].id = id;

        System.out.print("Enter Project Name: ");
        db[count].name = input.nextLine();

        System.out.print("Enter Project Description: ");
        db[count].description = input.nextLine();

        int prior;
        do {
            System.out.print("Enter Project's Priority (1-Low, 2-Medium, 3-High): ");
            prior = input.nextInt();
            input.nextLine();

            if (prior < 1 || prior > 3) {
                System.out.println("Invalid input! Please enter 1, 2, or 3.");
            }
        } while (prior < 1 || prior > 3);

        db[count].priority = prior;
        count++;

        System.out.println("\n=====================================================");
        System.out.println("        PROJECT ADDED SUCCESSFULLY!");
        System.out.println("=====================================================");
    }

    // READ
    public void showProjects() {
        if (count == 0) {
            System.out.println("\n====================================");
            System.out.println("        No projects found!");
            System.out.println("====================================");
            return;
        }
        System.out.println("           ALL PROJECTS");
        System.out.println("====================================");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ").");
            System.out.println("Project ID: " + db[i].id);
            System.out.println("Project Name: " + db[i].name);
            System.out.println("Project Description: " + db[i].description);

            String prior = (db[i].priority == 1) ? "Low (0% – 33%)" :
                    (db[i].priority == 2) ? "Medium (34% – 66%)" : "High (67% – 100%)";

            System.out.println("Project Priority: " + prior);
            System.out.println("-------------------------------------------");
        }
    }

    // UPDATE
    public void updateProject() {
        System.out.println("           UPDATE PROJECT");
        System.out.println("====================================");
        System.out.print("Enter Project ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < count; i++) {
            if (db[i].id == id) {

                System.out.print("New Project Name: ");
                db[i].name = input.nextLine();

                System.out.print("New Project Description: ");
                db[i].description = input.nextLine();

                int prior;
                do {
                    System.out.print("Enter Project's Priority (1-Low, 2-Medium, 3-High): ");
                    prior = input.nextInt();
                    input.nextLine();

                    if (prior < 1 || prior > 3) {
                        System.out.println("Invalid input! Please enter 1, 2, or 3.");
                    }
                } while (prior < 1 || prior > 3);

                db[i].priority = prior;
                System.out.println("\n=====================================================");
                System.out.println("        PROJECT UPDATED SUCCESSFULLY!");
                System.out.println("=====================================================");
                return;
            }
        }
        System.out.println("====================================");
        System.out.println("        Project not found.");
        System.out.println("====================================");

    }

    // DELETE
    public void deleteProject() {
        System.out.println("           DELETE PROJECT");
        System.out.println("====================================");
        System.out.print("Enter Project ID: ");
        int id = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (db[i].id == id) {

                for (int j = i; j < count - 1; j++) {
                    db[j] = db[j + 1];
                }

                count--;
                System.out.println("\n=====================================================");
                System.out.println("        PROJECT DELETED SUCCESSFULLY!");
                System.out.println("=====================================================");
                return;
            }
        }
        System.out.println("====================================");
        System.out.println("        Project not found.");
        System.out.println("====================================");

    }
}
