package lab.p03_employee_info;

import lab.p03_employee_info.UI.ConsoleClient;
import lab.p03_employee_info.UI.Formatter;
import lab.p03_employee_info.UI.InfoProvider;
import lab.p03_employee_info.businnes_layer.ConsoleFormatter;
import lab.p03_employee_info.businnes_layer.EmployeeInfoProvider;

public class Main {

    public static void main(String[] args) {
        InfoProvider employeeInfo = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();
        ConsoleClient consoleClient = new ConsoleClient(formatter, employeeInfo);

        System.out.println(consoleClient.getResult());
    }
}
