package modules;

import staticData.ExceptionMessages;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course {

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public Course(String name) {
        this.setName(name);
        this.setStudentsByName(new LinkedHashMap<>());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")){
            throw new IllegalArgumentException(ExceptionMessages.NULL_OR_EMPTY_VALUE);
        }
        this.name = name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    private void setStudentsByName(LinkedHashMap<String, Student> studentsByName) {
        this.studentsByName = studentsByName;
    }

    public void enrollStudent(Student student) {
        if (this.getStudentsByName().containsKey(student.getUserName())) {

            throw new KeyAlreadyExistsException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    student.getUserName(), this.getName()));
//            OutputWriter.displayException(String.format(
//                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
//                    student.getUserName(), this.getName()));
//            return;
        }

        this.getStudentsByName().put(student.getUserName(), student);
    }


}
