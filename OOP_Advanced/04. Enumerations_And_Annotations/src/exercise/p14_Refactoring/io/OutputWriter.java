package exercise.p14_Refactoring.io;

import exercise.p14_Refactoring.interfaces.Writer;

public class OutputWriter implements Writer{

    public void writeNewLine(String output){
        System.out.println(output);
    }

    public void writeLine(String output){
        System.out.print(output);
    }
}
