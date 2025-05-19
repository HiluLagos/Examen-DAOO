package ex2.visitor;

import ex2.element.Department;
import ex2.element.Employee;
import ex2.element.Project;

public class StatisticsVisitor implements Visitor<Stats> {
    @Override
    public Stats visit(Department department) {
        double cost = department.getMonthlyBudget();
        double hours= 0.0;
        for (Employee employee : department.getEmployees()) {
            hours += this.visit(employee).getHours();
        }
        return new Stats(hours, cost);
    }

    @Override
    public Stats visit(Employee employee) {
        return new Stats(employee.getHoursWorked(), employee.getMonthlySalary());
    }

    @Override
    public Stats visit(Project project) {
        double cost = 0.0;
        double hours= 0.0;
        for (Employee employee : project.getCollaborators()) {
            hours += this.visit(employee).getHours();
            cost += this.visit(employee).getCost();
        }
        return new Stats(cost, hours);
    }
}
