package exercise.p01_Harvesting_Fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Class aClass = RichSoilLand.class;
        Field[] fields = aClass.getDeclaredFields();

        while (true) {
            String command = console.readLine();
            if ("HARVEST".equals(command)) {
                break;
            }

            for (Field field : fields) {
                String fieldMod = Modifier.toString(field.getModifiers());
                if (!fieldMod.equals(command) && !command.equals("all")){
                    continue;
                }

                String type = field.getType().getSimpleName();
                String name = field.getName();

                System.out.println(fieldMod + " " + type + " " + name);
            }
        }
    }
}
