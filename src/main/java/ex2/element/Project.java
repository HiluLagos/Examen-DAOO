package ex2.element;

import ex2.visitor.Visitor;

import java.util.List;

public class Project implements Element {
    final private String name;
    final private String backlog;
    final private List<Employee> collaborators;
    private String status;

    public Project(String name, String description, List<Employee> collaborators, String status) {
        this.name = name;
        this.backlog = description;
        this.collaborators = collaborators;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getBacklog() {
        return backlog;
    }

    public List<Employee> getCollaborators() {
        return collaborators;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
