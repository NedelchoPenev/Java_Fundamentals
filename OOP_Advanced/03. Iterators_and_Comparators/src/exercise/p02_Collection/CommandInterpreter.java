package exercise.p02_Collection;

import java.util.stream.Stream;

public class CommandInterpreter {

    ListyIterator<String> iterator;

    public void readCommand(String input) {
        String[] args = input.split("\\s+");
        String command = args[0];
        switch (command) {
            case "Create":
                String[] varargs = Stream.of(args).skip(1).toArray(String[]::new);
                iterator = new ListyIterator<>(varargs);
                break;
            case "Move":
                System.out.println(iterator.move());
                break;
            case "HasNext":
                System.out.println(iterator.hasNext());
                break;
            case "Print":
                iterator.print();
                break;
            case "PrintAll":
                iterator.printAll();
        }
    }
}
