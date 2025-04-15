import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class studentRecordSystem {
    public static class Student {
        String name;
        int age;
        String agp;

        public Student(String name, int age, String agp) {
            this.name = name;
            this.age = age;
            this.agp = agp;
        }

        public String displayInfo() {
            String nameUpper = name.substring(0, 1).toUpperCase() + name.substring(1);
            return "Name: " + nameUpper + ", Age: " + age + ", AGP: " + agp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students are to be added to the database? ");
        int amount = sc.nextInt();
        sc.nextLine();

        Student[] database = new Student[amount];

        int counter = 0;
        System.out.println("Please enter your name, age, and AGP (e.g. John Smith, 18, 70%): ");
        try {
            for (int i = 0; i < amount; i++) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                while (!name.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Invalid data input.");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                }
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                while (age < 17 || age > 100) {
                    System.out.println("Invalid data input.");
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                }
                System.out.print("Average Grade Percentage: ");
                String agp = sc.nextLine();
                while (!agp.matches("([0-9][0-9]?|100)%")) {
                    System.out.println("Invalid data input.");
                    System.out.print("Average Grade Percentage: ");
                    agp = sc.nextLine();
                }
                database[i] = new Student(name, age, agp);
                counter++;
            }
            System.out.println("\n==Database==");
            BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"));
            for (Student s : database) {
                if (s != null) {
                    String info = s.displayInfo();
                    System.out.println(info);
                    writer.write(info);
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("\nWritten to the database successfully.");

        } catch (Exception e) {
            System.out.println("Invalid data input.");
        }
        sc.close();
    }
}
