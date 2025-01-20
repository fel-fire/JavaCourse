package oop;

public class StudentOnlyEven implements Rule {

    @Override
    public boolean check(int value) {
        return value%2 == 0;
    }
}
