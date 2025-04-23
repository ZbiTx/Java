import java.util.Scanner;
import java.util.Random;

public class bankAccount {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    // Probably the best and most useful function that I have ever created in my entire life, my new go-to function //
    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid integer value, please enter a whole number.");
                sc.nextLine();
            }
        }
    }

    public static int deposit(int money) {
        int depositVal = getIntInput("How much do you want to deposit into your account? ");
        money = money + depositVal;
        System.out.println("Deposit successful.");
        System.out.println("Invalid integer, exiting deposit.");
        return money;
    }
    public static int withdraw(int money) {
        int withdrawVal = getIntInput("How much do you want to withdraw? ");
        if (money < withdrawVal) {
            System.out.println("Insufficient funds.");
        } else {
            money = money - withdrawVal;
            System.out.println("Withdraw successful.");
        }
        return money;
    }

    public static String accountNumberGen(String accountNumber) {
        int num = rand.nextInt(9999 - 1000+1) + 1000;
        int num2 = rand.nextInt(9999 - 1000+1) + 1000;
        int num3 = rand.nextInt(9999 - 1000+1) + 1000;
        int num4 = rand.nextInt(9999 - 1000+1) + 1000;
        accountNumber = String.valueOf(num) + " " + String.valueOf(num2) + " " + String.valueOf(num3) + " " + String.valueOf(num4);
        return accountNumber;
    }
    public static String sortCodeGen(String sortCode) {
        int num = rand.nextInt(99 - 10 + 1) + 10;
        int num2 = rand.nextInt(99 - 10 + 1) + 10;
        int num3 = rand.nextInt(99 - 10 + 1) + 10;
        sortCode = String.valueOf(num) + "-" + String.valueOf(num2) + "-" + String.valueOf(num3);
        return sortCode;
    }
    public static int cvvGen(int cvv) {
        cvv = rand.nextInt(999 - 100 + 1) + 100;
        return cvv;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java Banking, please register an account.");
        System.out.print("Name (i.e. John): ");
        String name = sc.nextLine();
        while(!name.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid name");
            System.out.print("Name (i.e. Edith): ");
            name = sc.nextLine();
        }
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        int UIN = getIntInput("Unique Identification Number: ");
        int UINlength = (int) (Math.log10(UIN) + 1);
        while (UINlength < 3) {
            System.out.println("Your UIN must be at least 3 digits.");
            System.out.print("Unique Identification Number: ");
            UIN = sc.nextInt();
            UINlength = (int) (Math.log10(UIN) + 1);
        }

        int money = 1000;
        String accountNumber = "";
        accountNumber = accountNumberGen(accountNumber);
        String sortCode = "";
        sortCode = sortCodeGen(sortCode);
        int cvv = 0;
        cvv = cvvGen(cvv);


        while (true) {
            System.out.println("Welcome to Java Banking, " + name);
            System.out.println("1 Deposit | 2 Withdraw | 3 Show Balance | 4 View Digital Card | 5 Exit");
            int user_input = getIntInput("Enter: ");

            if (user_input == 1) {
                int tempUIN = getIntInput("Please enter your UIN: ");
                if (tempUIN == UIN) {
                    money = deposit(money);
                    System.out.println();
                }
                else {
                    System.out.println("Invalid UIN.");
                }
            } else if (user_input == 2) {
                int tempUIN = getIntInput("Please enter your UIN: ");
                if (tempUIN == UIN) {
                    money = withdraw(money);
                    System.out.println();
                }
                else {
                    System.out.println("Invalid UIN.");
                }
            } else if (user_input == 3) {
                int tempUIN = getIntInput("Please enter your UIN: ");
                if (tempUIN == UIN) {
                    System.out.println("Bank balance: £" + money + "\n");
                }
                else {
                    System.out.println("Invalid UIN.");
                }
            } else if (user_input == 4) {
                int tempUIN = getIntInput("Please enter your UIN: ");
                if (tempUIN == UIN) {
                    System.out.println("  __________________________________________ ");
                    System.out.println("/|                             Java Banking |");
                    System.out.println("/|                                          |");
                    System.out.println("/|           "+accountNumber+"            |");
                    System.out.println("/|                                          |");
                    System.out.println("/|   Sort Code: "+sortCode+"                    |");
                    System.out.println("/|   CVV Number: "+cvv+"                        |");
                    System.out.println("/|   Card status: Debit                     |");
                    System.out.println("/|                                          |");
                    System.out.println("/| "+name+"                                  ");
                    System.out.println("/|__________________________________________|\n");
                }
                else {
                    System.out.println("Invalid UIN.");
                }

            } else if (user_input == 5) {
                System.out.println("I hate to see you leave, but I love to see you walk away.");
                System.out.println("Goodbye, " + name + "!");
                break;
            } else {
                System.out.println("Please enter a valid option.\n");
            }
        }
        sc.close();
    }
}