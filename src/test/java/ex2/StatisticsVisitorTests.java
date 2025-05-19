package ex2;

import ex2.element.Department;
import ex2.element.Employee;
import ex2.visitor.ReportVisitor;
import ex2.visitor.StatisticsVisitor;
import ex2.visitor.Stats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StatisticsVisitorTests {

    @Test
    public void statisticsVisitorCanVisitEmployee_01() {
        StatisticsVisitor visitor = new StatisticsVisitor();
        Employee employee = new Employee("John Doe", 1000.55, 8);
        Stats result = visitor.visit(employee);
        Assertions.assertEquals(8, result.getHours());
        Assertions.assertEquals(1000.55, result.getCost());
    }

    @Test
    public void statisticsVisitorCanVisitDepartment_02() {
        StatisticsVisitor visitor = new StatisticsVisitor();
        Employee employee = new Employee("John Doe", 1000.55, 8);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        Department department = new Department("HR", employees, 50000);
        Stats result = visitor.visit(department);
        Assertions.assertEquals(8, result.getHours());
        Assertions.assertEquals(50000, result.getCost());
    }
}
