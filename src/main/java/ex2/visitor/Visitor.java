package ex2.visitor;

import ex2.element.Department;
import ex2.element.Employee;
import ex2.element.Project;

public interface Visitor<T> {
    T visit(Department department);
    T visit(Employee employee);
    T visit(Project project);
}
