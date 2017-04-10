package lab.p03_employee_info.businnes_layer;

import lab.p03_employee_info.database_layer.EmployeeDatabase;
import lab.p03_employee_info.UI.InfoProvider;
import lab.p03_employee_info.modules.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider{

    private EmployeeDatabase database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    @Override
    public List<Employee> getEmployeesBy(Comparator<Employee> comparator) {
        return this.database.readEmployees().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
