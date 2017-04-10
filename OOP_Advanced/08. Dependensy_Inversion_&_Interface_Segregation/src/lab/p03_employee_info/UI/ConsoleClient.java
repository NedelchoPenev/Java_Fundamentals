package lab.p03_employee_info.UI;

import lab.p03_employee_info.modules.Employee;

import java.util.Comparator;

public class ConsoleClient {

    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    public String getResult(){
        return this.formatter
                .format(this.infoProvider.getEmployeesBy(Comparator.comparing(Employee::getName)));
    }
}
