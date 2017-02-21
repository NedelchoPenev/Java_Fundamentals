package lab.P01_2_3_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command){
                case "Create":
                    createNewAccount(commands, accounts);
                    break;
                case "Deposit":
                    deposit(commands, accounts);
                    break;
                case "Withdraw":
                    withdraw(commands, accounts);
                    break;
                case "Print":
                    printAccount(commands, accounts);
                    break;
            }
        }
    }

    private static void withdraw(String[] commands, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commands[1]);
        double amount = Integer.parseInt(commands[2]);
        if (accounts.containsKey(id)){
            accounts.get(id).withdraw(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void deposit(String[] commands, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commands[1]);
        double amount = Integer.parseInt(commands[2]);
        if (accounts.containsKey(id)){
            accounts.get(id).deposit(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void printAccount(String[] commands, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commands[1]);
        if (accounts.containsKey(id)){
            System.out.printf("Account %s, balance %.2f%n", accounts.get(id), accounts.get(id).getBalance());
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createNewAccount(String[] commands, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commands[1]);
        if (accounts.containsKey(id)){
            System.out.println("Account already exists");
        } else {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(id);
            accounts.put(id, bankAccount);
        }
    }
}
