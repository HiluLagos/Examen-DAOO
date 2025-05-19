package ex2.visitor;

public class Stats {
    final private double hours;
    final private double cost;

    public Stats(double hours, double cost) {
        this.hours = hours;
        this.cost = cost;
    }

    public double getHours() {
        return hours;
    }

    public double getCost() {
        return cost;
    }
}
