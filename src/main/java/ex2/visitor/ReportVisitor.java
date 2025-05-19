package ex2.visitor;

import ex2.element.Department;
import ex2.element.Employee;
import ex2.element.Project;

public class ReportVisitor implements Visitor<String> {

    @Override
    public String visit(Department department) {
        StringBuilder output = new StringBuilder();
        output.append("Department name: ").append(department.getName()).append("\n");
        output.append("Department budget: ").append(department.getMonthlyBudget()).append("\n");
        output.append("Department employees: " + "\n");
        for (Employee employee : department.getEmployees()) {
            output.append(this.visit(employee)).append("\n");
        }
        return output.toString();
    }

    @Override
    public String visit(Employee employee) {
        return String.format("[Name: %s -- Hours: %.2f -- Salary: %.2f]", employee.getName(), employee.getHoursWorked(), employee.getMonthlySalary());
    }

    @Override
    public String visit(Project project) {
        StringBuilder output = new StringBuilder();
        output.append("[Project name: ").append(project.getName());
        output.append(" status: ").append(project.getStatus()).append("]\n");
        output.append("Project Backlog: ").append(project.getBacklog()).append("\n");
        output.append("Project collaborators: ").append("\n");
        for (Employee employee : project.getCollaborators()) {
            output.append(this.visit(employee)).append("\n");
        }
        return output.toString();
    }
}
