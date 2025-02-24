package edu.baykov.martialArts;

import java.util.ArrayList;

public class Karatist implements Fighter{


    private String name;

    public Karatist(String name) {
        this.name = name;
    }

    public void hit() {
        System.out.println(name + " бьет йоко-гери: Бац!");
    }
    public void kick() {
        System.out.println(name + " бьет чоку-цуки: Кия!");
    }
    public void hitInJump() {
        System.out.println(name + " бьет тоби-гери: Вжух!");
    }

}
