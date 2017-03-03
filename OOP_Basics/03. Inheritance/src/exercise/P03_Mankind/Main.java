package exercise.P03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] std = console.readLine().split("\\s+");
        String firstNameStudent = std[0];
        String lastNameStudent = std[1];
        String facultyNumber = std[2];

        String[] wrk = console.readLine().split("\\s+");
        String firstNameWorker = wrk[0];
        String lastNameWorker = wrk[1];
        double weekSalary = Double.parseDouble(wrk[2]);
        double workHours = Double.parseDouble(wrk[3]);

        try {
            Student student = new Student(firstNameStudent, lastNameStudent, facultyNumber);
            System.out.println(student);
            Worker worker = new Worker(firstNameWorker, lastNameWorker, weekSalary, workHours);
            System.out.println(worker);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
