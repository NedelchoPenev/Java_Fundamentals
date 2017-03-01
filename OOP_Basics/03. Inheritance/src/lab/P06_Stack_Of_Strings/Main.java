package lab.P06_Stack_Of_Strings;

public class Main {

    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("Ivan");
        sos.push("Mimi");
        sos.push("Mai");
        sos.push("Goshoo");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
