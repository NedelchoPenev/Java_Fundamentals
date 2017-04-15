package exercise.p04_Work_Force;

import exercise.p04_Work_Force.contracts.Workable;
import exercise.p04_Work_Force.factories.EmployeesFactory;
import exercise.p04_Work_Force.models.Job;
import exercise.p04_Work_Force.models.MyList;
import exercise.p04_Work_Force.models.employees.Employee;

import java.util.TreeMap;

public class CommandInterpreter {

    private static final String COMMAND_PATH = "exercise.p04_Work_Force.commands.";

    private TreeMap<String, Employee> employees;
    private MyList<Workable> jobs;

    public CommandInterpreter() {
        this.employees = new TreeMap<>();
        this.jobs = new MyList<>();
    }

    public void createEmployee(String type, String name) throws ReflectiveOperationException {
        this.employees.put(name, EmployeesFactory.getEmployee(type, name));
    }

    public void createJob(String name, int requiredHours, String employee) {
        Employee emp = this.employees.get(employee);
        Job newJob = new Job(name, requiredHours, emp);
        newJob.addJobCompletedListener(jobs);
        this.jobs.add(newJob);
    }

    public void passWeek() {
        Workable[] jobsArr = new Workable[this.jobs.size()];
        this.jobs.toArray(jobsArr);
        for (Workable workable : jobsArr) {
            workable.update();
        }
    }

    void status() {
        this.jobs.forEach(System.out::println);
    }
}

