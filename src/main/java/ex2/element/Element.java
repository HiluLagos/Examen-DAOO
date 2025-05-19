package ex2.element;

import ex2.visitor.Visitor;

public interface Element {
    void accept(Visitor visitor);
}
