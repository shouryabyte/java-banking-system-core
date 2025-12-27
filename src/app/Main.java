package app;

import java.util.Scanner;

import service.BankService;
import service.BankServiceImpl;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();

        System.out.println("Welcome to Console Bank");

        boolean running = true;

        while (running) {
            System.out.println("""
                    1) Open Account
                    2) Deposit
                    3) Withdraw
                    4) Transfer
                    5) Account Statement
                    6) List Accounts
                    7) Search Accounts by Customer Name
                    0) Exit
                    """);

            System.out.print("CHOOSE: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> openAccount(scanner, bankService);
                case "2" -> deposit(scanner, bankService);
                case "3" -> withdraw(scanner, bankService);
                case "4" -> transfer(scanner, bankService);
                case "5" -> statement(scanner, bankService);
                case "6" -> listAccounts(scanner, bankService);
                case "7" -> searchAccounts(scanner, bankService);
                case "0" -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }

        scanner.close();
        System.out.println("Thank you for using Console Bank!");
    }

    // ---------------- MENU ACTIONS ----------------

    private static void openAccount(Scanner scanner, BankService bankService) {

        System.out.print("Customer name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Customer email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Account Type (SAVING / CURRENT): ");
        String accountType = scanner.nextLine().trim();

        String accountNumber = bankService.openAccount(name, email, accountType);

        System.out.println("✅ Account created successfully");
        System.out.println("Account Number: " + accountNumber);
    }

    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.println("Deposit feature coming soon...");
    }

    private static void withdraw(Scanner scanner, BankService bankService) {
        System.out.println("Withdraw feature coming soon...");
    }

    private static void transfer(Scanner scanner, BankService bankService) {
        System.out.println("Transfer feature coming soon...");
    }

    private static void statement(Scanner scanner, BankService bankService) {
        System.out.println("Statement feature coming soon...");
    }

    private static void listAccounts(Scanner scanner, BankService bankService) {
    if (bankService.listAccounts().isEmpty()) {
        System.out.println("No accounts found.");
        return;
    }

    bankService.listAccounts().forEach(a ->
        System.out.println(
            a.getAccountNumber() + " | " +
            a.getAccountType() + " | " +
            a.getBalance()
        )
    );
}


    private static void searchAccounts(Scanner scanner, BankService bankService) {
        System.out.println("Search feature coming soon...");
    }
}
