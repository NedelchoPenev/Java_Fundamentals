package lab.p03_employee_info.businnes_layer;

import lab.p03_employee_info.modules.Employee;

import java.util.List;

public interface Database {

    List<Employee> readEmployees();
}
