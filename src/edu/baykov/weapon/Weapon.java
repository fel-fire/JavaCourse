package edu.baykov.weapon;
/**
 * <p>Класс {@code Weapon}, реализующий сущность "Оружие", которая описывается следующим образом:</p>
 * <p>•	Имеет Количество патронов {@code ammo} (целое не отрицательное число)</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    16-01-2025
 */
abstract class Weapon {
    /**
     * Количество патронов
     */
    int ammo;

    /**
     * Конструирует объект с количеством патронов {@code ammo}
     * @param ammo количество патронов
     */
    public Weapon(int ammo) {
        if (ammo<0) throw new IllegalArgumentException("Ammo must be more than 0");
        this.ammo = ammo;
    }

    /**
     * Метод стрельбы
     */
    abstract void shoot();

    /**
     * Метод, возвращающий количество патронов
     * @return количество патронов
     */
    public int ammo() {
        return ammo;
    }

    /**
     * Метод, извлекающий 1 патрон.
     */
    public boolean getAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true; // Заменил на true строку из задачника (было - return false). Нормально не работало
    }

    /**
     * Метод, заряжающий оружие
     * @param ammo количество патронов
     * @return количество патронов, остававшееся в оружии
     */
    public int load(int ammo) {
        if (ammo < 0) throw new IllegalArgumentException("Ammo must be more than 0");
        int tmp = this.ammo; // Заменил на это строку из задачника (было - int tmp = ammo). Нормально не работало
        this.ammo = ammo;
        return tmp;
    }
}
