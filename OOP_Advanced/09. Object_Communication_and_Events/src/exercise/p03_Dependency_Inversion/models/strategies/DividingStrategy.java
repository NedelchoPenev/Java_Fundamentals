package exercise.p03_Dependency_Inversion.models.strategies;

import exercise.p03_Dependency_Inversion.contracts.Calculatable;

public class DividingStrategy implements Calculatable {

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }
}
