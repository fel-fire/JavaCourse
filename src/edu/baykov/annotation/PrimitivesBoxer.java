package edu.baykov.annotation;

/**
 8.3.2. Такой вот временный костыль, чтобы избавиться от классов примитивов.
 Хотя, как говорится, нет ничего более постоянного, чем временное.
 * @author   Nikolay Baykov
 */

class PrimitivesBoxer {

    public static Class<?> box(Class<?> clz) {
        Class<?> key = clz;
        if (key.isPrimitive()) {
            if (key == int.class) key = Integer.class;
            if (key == double.class) key = Double.class;
            if (key == byte.class) key = Byte.class;
            if (key == long.class) key = Long.class;
            if (key == short.class) key = Short.class;
            if (key == float.class) key = Float.class;
            if (key == boolean.class) key = Boolean.class;
            if (key == char.class) key = Character.class;
        }
        return key;
    }
}
