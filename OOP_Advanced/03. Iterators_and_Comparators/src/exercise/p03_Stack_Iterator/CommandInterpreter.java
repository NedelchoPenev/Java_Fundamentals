package exercise.p03_Stack_Iterator;

import java.util.stream.Stream;

public class CommandInterpreter {

    private Stack<Integer> stack;

    public CommandInterpreter() {
        this.setStack(new Stack<>());
    }

    public void readCommands(String input){
        String[] args = input.split("[\\s+|,]+");

        String command = args[0];
        if (command.equals("Push")){
            Integer[] varargs = Stream.of(args).skip(1)
                    .map(Integer::parseInt).toArray(Integer[]::new);
            this.getStack().push(varargs);
        } else {
            try {
                this.getStack().pop();
            } catch (UnsupportedOperationException ex){
                System.out.println(ex.getMessage());
            }

        }
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    private void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }
}
