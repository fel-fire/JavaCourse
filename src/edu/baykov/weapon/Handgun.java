package edu.baykov.weapon;

import lombok.Getter;

/**
 * <p>Класс, реализующий сущность "пистолет", которая описывается следующим образом:</p>
 * <p>•	Имеет Количество патронов (целое число)</p>
 * <p>•	Имеет емкость магазина (целое число)</p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    03-01-2025
 */
@Getter
public class Handgun extends Weapon{
    /**
     * Емкость магазина
     */
    private final int capacity;

    /**
     * Конструирует пистолет емкостью магазина capacity и количеством патронов - 0
     * @param capacity емкость магазина
     */
    public Handgun(int capacity) {
        this(0, capacity);
    }

    /**
     * Конструирует пистолет емкостью магазина capacity и количеством патронов - bullets. Вызывает служебный
     * метод setValidBullets(bullets).
     * @param ammo количество патронов.
     * @param capacity емкость магазина.
     * @throws IllegalArgumentException если емкость магазина отрицательное число либо 0.
     */
    public Handgun(int ammo, int capacity) {
        super(getValidAmmoValue(ammo, capacity));
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must not be less than 1 and bullets");
        this.capacity = capacity;


    }

    /**
     * Служебный метод, проверяющий соответствие переданного значения bullets емкости магазина capacity. В случае если
     * количество заряжаемых патронов больше, чем емкость магазина, присваивает полю bullets значение capacity.
     * @param bullets количество заряжаемых патронов
     * @throws IllegalArgumentException если количество заряжаемых патронов отрицательное.
     */
    private static int getValidAmmoValue(int bullets, int capacity) {
        return Math.min(bullets, capacity);
    }

    /**
     * Метод, заряжающий пистолет одним магазином емкостью {@code capacity} с переданным
     * в качестве параметра количеством патронов {@code ammo}. В случае, если количество
     * заряжаемых патронов превышает емкость магазина, заряжает один полный магазин. Возвращает
     * количество патронов, оставшихся в разряженном магазине.
     * @param ammo количество заряжаемых патронов
     * @return количество патронов, оставшихся в разряженном магазине.
     */
    @Override
    public int load(int ammo) {
        return super.load(getValidAmmoValue(ammo, capacity));
    }

    /**
     * Метод, разряжающий пистолет и возвращающий количество патронов, которые были разражены.
     * @return количество разряженных патронов.
     */
    public int unload() {
        int tmp = ammo;
        super.load(0);
        return tmp;
    }

    /**
     * Метод, возвращающий true, если пистолет заряжен и false, если пистолет разряжен.
     * @return логическое значение состояния пистолета.
     */
    public boolean isLoaded() {
        return ammo() > 0;
    }

    /**
     * Метод, осуществляющий выстрел из пистолета с отображением сведений в консоли.
     * В случае выстрела отображается "Бах!", при пустом магазине - "Клац!".
     */
    @Override
    public void shoot() {
        if (getAmmo()) {
            System.out.println("Бах!");
        }
        else System.out.println("Клац!");
    }
}
