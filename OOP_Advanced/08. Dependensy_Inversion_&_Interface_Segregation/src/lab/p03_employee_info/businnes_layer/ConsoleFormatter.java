package lab.p03_employee_info.businnes_layer;

import lab.p03_employee_info.UI.Formatter;

public class ConsoleFormatter implements Formatter{

    public String format(Iterable<?> employees) {
        StringBuilder sb = new StringBuilder();
        for (Object employee : employees) {
            sb.append(employee)
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
