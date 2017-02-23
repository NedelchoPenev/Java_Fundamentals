package exercise.P04_Company_Roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        TreeMap<String, Double> highestSalaryDepartment = new TreeMap<>();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] split = console.readLine().split("\\s+");
            String name = split[0];
            double salary = Double.parseDouble(split[1]);
            String position = split[2];
            String department = split[3];
            String email;
            int age;

            Employee employee = new Employee(name, salary, position, department);

            highestSalaryDepartment.putIfAbsent(department, 0.0);
            double oldValue = highestSalaryDepartment.get(department);
            highestSalaryDepartment.put(department, oldValue + salary);

            if (split.length == 5){
                if (split[4].contains("@")){
                    email = split[4];
                    employee.setEmail(email);
                } else {
                    age = Integer.parseInt(split[4]);
                    employee.setAge(age);
                }
            } else if (split.length == 6){
                email = split[4];
                age = Integer.parseInt(split[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }

            employees.add(employee);
        }

        String department = highestSalaryDepartment.entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .findFirst().get().getKey();
        System.out.printf("Highest Average Salary: %s%n", department);
        employees.stream()
                .filter(d -> d.getDepartment().equals(department))
                .sorted((s1, s2) -> Double.compare(s2.getSalary(), s1.getSalary()))
                .forEach(System.out::println);
    }
}
