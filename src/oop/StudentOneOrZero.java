package oop;

public class StudentOneOrZero implements Rule {

    @Override
    public boolean check(int value) {
        return value == 1 || value == 0;
    }
}
