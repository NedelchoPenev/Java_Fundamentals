package exercise.p03_04_05_Barracks.core;

import exercise.p03_04_05_Barracks.contracts.*;
import exercise.p03_04_05_Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

	private CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable command = this.commandInterpreter.interpretCommand(data, commandName);
				String result = command.execute();
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (ReflectiveOperationException | IOException e) {
                e.printStackTrace();
            }
        }
	}
}
