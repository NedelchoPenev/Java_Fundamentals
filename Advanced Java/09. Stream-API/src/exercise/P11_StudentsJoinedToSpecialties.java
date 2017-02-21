package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class P11_StudentsJoinedToSpecialties {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> specialties = new ArrayList<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("Students:")) {
                break;
            }

            String specialty = input[0] + " " + input[1];
            String facultyNumber = input[2];
            StudentSpecialty studentSpecialty = new StudentSpecialty(specialty, facultyNumber);
            specialties.add(studentSpecialty);
        }

        List<Student> students = new ArrayList<>();
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String facultyNumber = input[0];
            String name = input[1] + " " + input[2];
            Student student = new Student(name, facultyNumber);
            students.add(student);
        }

        BiPredicate<StudentSpecialty, Student> predicate = (p1, p2) ->
                p1.getFacultyNumber().equals(p2.getFacultyNumber());

        students.stream()
                .sorted((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName()))
                .forEach(sp -> specialties.stream().filter(spec -> predicate.test(spec, sp))
                        .forEach(a -> System.out.printf("%s %s %s%n"
                                , sp.getStudentName()
                                , sp.getFacultyNumber()
                                , a.getSpecialtyName())));
    }
}

class StudentSpecialty {

    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class Student {

    private String studentName;
    private String facultyNumber;

    public Student(String studentName, String facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}