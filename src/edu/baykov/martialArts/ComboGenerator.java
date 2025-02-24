package edu.baykov.martialArts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class ComboGenerator {
    private Random random = new Random();
    private Method[] methods = Fighter.class.getDeclaredMethods();
    private int methodsQuantity = methods.length;

    public ConcreteCombo generateCombo(int numberOfBlows) {
        ConcreteCombo combo = new ConcreteCombo();
        for (int i = 0; i < numberOfBlows; i++) {
            int index = random.nextInt(methodsQuantity);
            combo.addActInCombo((fighter) -> {
                try {
                    methods[index].invoke(fighter);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return combo;
    }

    public ConcreteCombo generateFatality() {
        return generateCombo(100);
    }

}
