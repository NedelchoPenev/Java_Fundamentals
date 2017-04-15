package exercise.p03_Dependency_Inversion;

import exercise.p03_Dependency_Inversion.contracts.Calculatable;
import exercise.p03_Dependency_Inversion.models.PrimitiveCalculator;
import exercise.p03_Dependency_Inversion.models.strategies.AdditionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, ReflectiveOperationException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Calculatable defaultOperator = new AdditionStrategy();
        PrimitiveCalculator calculator = new PrimitiveCalculator(defaultOperator);

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("End".equals(input[0])) {
                break;
            }

            if (input[0].equals("mode")) {
                String operator = input[1];

                switch (operator) {
                    case "+":
                        calculator.changeStrategy("Addition");
                        break;
                    case "-":
                        calculator.changeStrategy("Subtraction");
                        break;
                    case "*":
                        calculator.changeStrategy("Multiplying");
                        break;
                    case "/":
                        calculator.changeStrategy("Dividing");
                        break;
                        default:
                            throw new UnsupportedOperationException();

                }
            } else {
                int firstNumber = Integer.parseInt(input[0]);
                int secondNumber = Integer.parseInt(input[1]);
                System.out.println(calculator.performCalculation(firstNumber, secondNumber));
            }
        }
    }
}
