package exercise.p03_Dependency_Inversion.models;

import exercise.p03_Dependency_Inversion.contracts.Calculatable;

import java.lang.reflect.Constructor;

public class PrimitiveCalculator {

    private static final String CLASS_PATH = "exercise.p03_Dependency_Inversion.models.strategies.";

    private Calculatable operator;

    public PrimitiveCalculator(Calculatable operator){
        this.operator = operator;
    }

    public void changeStrategy(String operator) throws ReflectiveOperationException {
        Class currentOperator = Class.forName(CLASS_PATH + operator + "Strategy");
        Constructor constructor = currentOperator.getDeclaredConstructor();
        constructor.setAccessible(true);

        this.operator = (Calculatable) constructor.newInstance();
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.operator.calculate(firstOperand, secondOperand);
    }
}
