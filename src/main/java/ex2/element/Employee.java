package ex2.element;

import ex2.visitor.Visitor;

public class Employee implements Element {
    final private String name;
    final private double monthlySalary;
    final private double hoursWorked;

    public Employee(String name, double monthlySalary, double hoursWorked) {
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
