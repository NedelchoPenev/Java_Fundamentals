package repository;

import io.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class PepositorySorters {

    public static void printSortedStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String comparisonType,
            int numberOfStudents) {

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator =
                Comparator.comparingDouble(x -> x.getValue()
                        .stream().mapToInt(Integer::intValue).average().getAsDouble());

        List<String> sortedStudents = courseData.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }

        for (String student : sortedStudents) {
            OutputWriter.printStudent(student, courseData.get(student));
        }
    }

}
