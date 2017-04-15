package exercise.p04_Work_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, ReflectiveOperationException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        CommandInterpreter commandInterpreter = new CommandInterpreter();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("End".equals(input[0])) {
                break;
            }

            String command = input[0];
            switch (command){
                case "Job":
                    String jobName = input[1];
                    int requiredHours = Integer.parseInt(input[2]);
                    String employeeName = input[3];
                    commandInterpreter.createJob(jobName, requiredHours, employeeName);
                    break;
                case "StandartEmployee":
                case "PartTimeEmployee":
                    String name = input[1];
                    commandInterpreter.createEmployee(command, name);
                    break;
                case "Pass":
                    commandInterpreter.passWeek();
                    break;
                case "Status":
                    commandInterpreter.status();
                    break;

            }
        }
    }
}
