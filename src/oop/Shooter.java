package oop;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Shooter {
    @Getter
    private String name;
    private Weapon weapon;

    public Shooter(String name) {
        this.name = name;
    }

    public Shooter(String name, Weapon weapon) {
        this(name);
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon == null) System.out.println("Не могу участвовать в перестрелке");
        else {
            weapon.load(5);
            weapon.shoot();
        }
    }
}
