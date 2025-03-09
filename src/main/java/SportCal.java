import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportCal {
    private static class Activity {
        public String name;
        int duration;

        Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
    }

    List<Activity> activities;

    public SportCal() {
        activities = new ArrayList<>();
    }

    public void logActivity(String name, int duration) {
        activities.add(new Activity(name, duration));
    }

    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged.");
        } else {
            System.out.println("Logged Activities:");
            for (Activity activity : activities) {
                System.out.printf("Activity: %s, Duration: %d minutes\n", activity.name, activity.duration);
            }
        }
    }

    public int calculateTotalTime() {
        int totalTime = 0;
        for (Activity activity : activities) {
            totalTime += activity.duration;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        SportCal sportCal = new SportCal();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Sport Activity Logger =====");
            System.out.println("1. Log Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Calculate Total Time");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the activity name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the duration (in minutes): ");
                    int duration = scanner.nextInt();
                    sportCal.logActivity(name, duration);
                    break;
                case 2:
                    sportCal.viewActivities();
                    break;
                case 3:
                    System.out.printf("Total time spent on sports this week: %d minutes\n", sportCal.calculateTotalTime());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}