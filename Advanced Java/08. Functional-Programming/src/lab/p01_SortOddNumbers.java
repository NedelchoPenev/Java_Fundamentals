package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p01_SortOddNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.asList(console.readLine().split(", "));

        StringBuilder nums = new StringBuilder();
        List<Integer> numbers = input.stream()
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        numbers.forEach(n -> nums.append(String.format("%d, ", n)));

        nums.delete(nums.length() - 2, nums.length());
        System.out.println(nums);

        numbers.sort(Integer::compareTo);

        StringBuilder sortedNums = new StringBuilder();
        numbers.forEach(n -> sortedNums.append(String.format("%d, ", n)));
        sortedNums.delete(sortedNums.length() - 2, sortedNums.length());
        System.out.println(sortedNums);
    }
}
