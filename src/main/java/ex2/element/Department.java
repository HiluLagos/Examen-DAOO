package ex2.element;

import ex2.visitor.Visitor;

import java.util.List;

public class Department implements Element{
    final private String name;
    final private List<Employee> employees;
    final private double monthlyBudget;

    public Department(String name, List<Employee> employees, double monthlyBudget) {
        this.name = name;
        this.employees = employees;
        this.monthlyBudget = monthlyBudget;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
