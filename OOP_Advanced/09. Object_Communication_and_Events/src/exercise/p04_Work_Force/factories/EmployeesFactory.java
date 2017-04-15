package exercise.p04_Work_Force.factories;

import exercise.p04_Work_Force.models.employees.Employee;

import java.lang.reflect.Constructor;

public class EmployeesFactory {

    private static final String PATH = "exercise.p04_Work_Force.models.employees.";

    public static Employee getEmployee(String type, String name) throws ReflectiveOperationException {

        Class aClass = Class.forName(PATH + type);
        Constructor constructor = aClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        return (Employee) constructor.newInstance(name);
    }
}
