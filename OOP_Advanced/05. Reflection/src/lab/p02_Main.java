package lab;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class p02_Main {

    public static void main(String[] args) {
        Class aClass = Reflection.class;
        Method[] methods = aClass.getDeclaredMethods();

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("get")){
                if (method.getParameterTypes().length == 0){
                    getters.add(method);
                }
            } else if (method.getName().startsWith("set")){
                if (method.getParameterTypes().length == 1){
                    setters.add(method);
                }
            }
        }

        getters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s will return %s%n",
                        m.getName(),
                        m.getReturnType()));

        setters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s and will set field of %s%n",
                        m.getName(),
                        m.getParameterTypes()[0]));
    }
}
