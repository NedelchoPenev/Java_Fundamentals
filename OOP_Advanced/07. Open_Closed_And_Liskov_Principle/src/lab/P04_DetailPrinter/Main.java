package lab.P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan"));
        employees.add(new Employee("Venci"));
        employees.add(new Manager("Pesho", "docs"));
        employees.add(new Worker("Vanko", 1));
        DetailsPrinter detailsPrinter = new DetailsPrinter(employees);

        detailsPrinter.printDetails();
    }

}
