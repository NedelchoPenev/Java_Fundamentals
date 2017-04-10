package lab.p03_employee_info.UI;

import lab.p03_employee_info.modules.Employee;

import java.util.Comparator;
import java.util.List;

public interface InfoProvider {

    List<Employee> getEmployeesBy(Comparator<Employee> comparator);

}
