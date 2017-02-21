package lab.P05_Static_Id_and_Rate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccountC> accounts = new HashMap<>();

        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command) {
                case "Create":
                    createNewAccount(accounts);
                    break;
                case "Deposit":
                    deposit(commands, accounts);
                    break;
                case "GetInterest":
                    getInterest(commands, accounts);
                    break;
                case "SetInterest":
                    setInterest(commands, accounts);
                    break;
            }
        }
    }

    private static void setInterest(String[] commands, HashMap<Integer, BankAccountC> accounts) {
        double interest = Double.parseDouble(commands[1]);
        BankAccountC.setInterest(interest);
    }

    private static void getInterest(String[] commands, HashMap<Integer, BankAccountC> accounts) {
        int id = Integer.parseInt(commands[1]);
        int years = Integer.parseInt(commands[2]);
        if (accounts.containsKey(id)) {
            System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void deposit(String[] commands, HashMap<Integer, BankAccountC> accounts) {
        int id = Integer.parseInt(commands[1]);
        double amount = Double.parseDouble(commands[2]);
        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amount);
            System.out.printf("Deposited %d to %s%n", (int) amount, accounts.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createNewAccount(HashMap<Integer, BankAccountC> accounts) {
        BankAccountC bankAccount = new BankAccountC();
        accounts.put(bankAccount.getId(), bankAccount);
        System.out.printf("Account %s created%n", bankAccount);
    }
}
