import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class P02_Earthquake {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        ArrayDeque<ArrayDeque<Integer>> sequences = new ArrayDeque<>();
        for (int i = 0; i < lines; i++) {
            String[] input = console.readLine().split("\\s+");
            ArrayDeque<Integer> numbers = new ArrayDeque<>();
            for (String num : input) {
                numbers.offer(Integer.parseInt(num));
            }

            sequences.offer(numbers);
        }

        List<Integer> seismicities = new ArrayList<>();
        while (sequences.size() != 0){
            ArrayDeque<Integer> numbers = sequences.poll();
            if (numbers.size() == 1){
                seismicities.add(numbers.poll());
                continue;
            }
            int seismicity = numbers.poll();
            int integer = numbers.poll();
            while (true){
                if (seismicity < integer){
                    seismicities.add(seismicity);
                    numbers.addFirst(integer);
                    sequences.offer(numbers);
                    break;
                } else {
                    if (numbers.size() == 0){
                        seismicities.add(seismicity);
                        break;
                    }
                    integer = numbers.poll();
                }
            }
        }

        System.out.println(seismicities.size());
        for (Integer seismicity : seismicities) {
            System.out.print(seismicity + " ");
        }
    }
}
