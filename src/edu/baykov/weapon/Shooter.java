package edu.baykov.weapon;

import lombok.Getter;
import lombok.Setter;
/**
 * <p>Класс {@code Shooter}, реализующий сущность "Стрелок", которая описывается следующим образом:</p>
 * <p>•	Имеет имя {@code name} (строка)</p>
 * <p>•	Имеет оружие {@code weapon} (Weapon)</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    16-01-2025
 */
@Setter
public class Shooter {
    /**
     * Имя
     */
    @Getter
    private String name;
    /**
     * Оружие
     */
    private Weapon weapon;

    /**
     * Контруирует стрелка из имени
     * @param name имя
     */
    public Shooter(String name) {
        this.name = name;
    }

    /**
     * Контруирует стрелка из имени и оружия
     * @param name имя
     * @param weapon оружие
     */
    public Shooter(String name, Weapon weapon) {
        this(name);
        this.weapon = weapon;
    }

    /**
     * Метод, заряжающий в оружие 5 патронов и заставляющий стрелка выстрелить
     */
    public void shoot() {
        if (weapon == null) System.out.println("Не могу участвовать в перестрелке");
        else {
            weapon.load(5);
            weapon.shoot();
        }
    }
}
