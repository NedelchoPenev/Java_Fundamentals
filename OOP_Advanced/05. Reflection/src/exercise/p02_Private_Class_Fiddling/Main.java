package exercise.p02_Private_Class_Fiddling;

import exercise.p02_Private_Class_Fiddling.models.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		Class<BlackBoxInt> boxInt = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = boxInt.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        while (true) {
		    String[] input = console.readLine().split("_");
		    if ("END".equals(input[0])) {
		        break;
		    }

		    String methodCall = input[0];
		    int number = Integer.parseInt(input[1]);

            Method method = boxInt.getDeclaredMethod(methodCall, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, number);
            Field field = boxInt.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
	}
}
