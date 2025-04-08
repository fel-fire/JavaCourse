package edu.baykov.spring;

public class RandomIntGenerator {

    private RandomIntGenerator(){}

    public static int get() {
        return (int) (Math.random()*100);
    }
}
