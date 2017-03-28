package lab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Class aClass = Reflection.class;
        List<Field> fields = Arrays.asList(aClass.getDeclaredFields());
        fields.stream().sorted(Comparator.comparing(Field::getName)).forEach(field -> {
            if (!Modifier.isPrivate(field.getModifiers())){
                System.out.printf("%s must be private!%n", field.getName());
            }
        });


        List<Method> methods = Arrays.asList(aClass.getDeclaredMethods());
        methods.sort(Comparator.comparing(Method::getName));
        for (Method method : methods) {
            if (method.getName().startsWith("get")){
                if (method.getParameterTypes().length == 0){
                    if (!Modifier.isPublic(method.getModifiers())){
                        System.out.printf("%s have to be public!%n", method.getName());
                    }
                }
            } else if (method.getName().startsWith("set")){
                if (method.getParameterTypes().length == 1){
                    if (!Modifier.isPrivate(method.getModifiers())){
                        System.out.printf("%s have to be private!", method.getName());
                    }
                }
            }
        }
    }
}
