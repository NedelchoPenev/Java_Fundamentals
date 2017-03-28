package lab;

public class p01_Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class aClass = Reflection.class;
        System.out.println(aClass);

        Class superClass = aClass.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection reflection = (Reflection) aClass.newInstance();
        System.out.println(reflection);
    }
}
