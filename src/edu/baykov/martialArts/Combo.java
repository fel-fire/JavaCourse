package edu.baykov.martialArts;

public interface Combo {
    void makeCombo(Fighter t);
    void addActInCombo(ConcreteCombo.Action act);
}
