package ex2;

import ex2.element.Department;
import ex2.element.Employee;
import ex2.element.Project;
import ex2.visitor.ReportVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReportVisitorTests {

    @Test
    public void reportVisitorReturnsEmployeeDataWhenVisitingIt_01(){
        ReportVisitor visitor = new ReportVisitor();
        Employee employee = new Employee("John Doe", 1000.55, 8);
        Assertions.assertEquals("[Name: John Doe -- Hours: 8.00 -- Salary: 1000.55]", visitor.visit(employee));
    }

    @Test
    public void reportVisitorReturnsDepartmentDataWhenVisitingIt_02(){
        ReportVisitor visitor = new ReportVisitor();
        Employee employee = new Employee("John Doe", 1000.55, 8);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        Department department = new Department("HR", employees, 50000);
        Assertions.assertEquals("Department name: HR\n" +
                "Department budget: 50000.0\n" +
                "Department employees: \n" +
                "[Name: John Doe -- Hours: 8.00 -- Salary: 1000.55]\n" , visitor.visit(department));
    }

    @Test
    public void reportVisitorReturnsProjectDataWhenVisitingIt_03(){
        ReportVisitor visitor = new ReportVisitor();
        Employee employee = new Employee("John Doe", 1000.55, 8);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        Project project = new Project("Project", "Task1-Task2", employees, "In Progress");
        Assertions.assertEquals("[Project name: Project status: In Progress]\n" +
                "Project Backlog: Task1-Task2\n" +
                "Project collaborators: \n" +
                "[Name: John Doe -- Hours: 8.00 -- Salary: 1000.55]\n", visitor.visit(project));
    }
}
