package modules;

import staticData.ExceptionMessages;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public Student(String userName) {
        this.setUserName(userName);
        this.setEnrolledCourses(new LinkedHashMap<>());
        this.setMarksByCourseName(new LinkedHashMap<>());
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        if (userName == null || userName.trim().equals("")){
            throw new IllegalArgumentException(ExceptionMessages.NULL_OR_EMPTY_VALUE);
        }
        this.userName = userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    private void setEnrolledCourses(LinkedHashMap<String, Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    private void setMarksByCourseName(LinkedHashMap<String, Double> marksByCourseName) {
        this.marksByCourseName = marksByCourseName;
    }

    public void enrollInCourse(Course course) {
        if (this.getEnrolledCourses().containsKey(course)) {
            throw new KeyAlreadyExistsException(String.format(ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    this.getUserName(), course.getName()));
//            OutputWriter.displayException(String.format(
//                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
//                    this.getUserName(), course.getName()));
//            return;
        }

        this.getEnrolledCourses().put(course.getName(), course);
    }

    public void setMarkOnCourse(String courseName, int... scores) {
        if (! this.getEnrolledCourses().containsKey(courseName)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
//            OutputWriter.displayException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
//            return;
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
//            OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
//            return;
        }

        double mark = this.calculateMark(scores);
        this.getMarksByCourseName().put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
