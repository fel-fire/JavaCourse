package edu.baykov.martialArts;

import java.util.ArrayList;

public class ConcreteCombo implements Combo{

    public interface Action {
        void doAction(Fighter fighter);
    }
    ArrayList<Action> sequence = new ArrayList<>();

    public void addActInCombo(Action act) {
        sequence.add(act);
    }

    void removeLastActInCombo() {
        sequence.removeLast();
    }

    public void makeCombo(Fighter fighter) {
        for (Action act: sequence) act.doAction(fighter);
    }






}
