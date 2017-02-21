package lab.P04_Define_Person_Class;

import lab.P05_Static_Id_and_Rate.BankAccountC;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<BankAccountC> accounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccountC> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance(){
        return accounts.stream().mapToDouble(BankAccountC::getBalance).sum();
    }
}
