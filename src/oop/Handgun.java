package oop;

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
public class Handgun {
    /**
     * Количество патронов
     */
    private int bullets;

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
     * @param bullets количество патронов.
     * @param capacity емкость магазина.
     * @throws IllegalArgumentException если емкость магазина отрицательное число либо 0.
     */
    public Handgun(int bullets, int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must not be less than 1 and bullets");
        this.capacity = capacity;
        setValidBullets(bullets);

    }

    /**
     * Конструирует пистолет по умолчанию с полным магазином емкостью 5 патронов.
     */
    public Handgun() {
        this(5, 5);
    }

    /**
     * Служебный метод, проверяющий соответствие переданного значения bullets емкости магазина capacity. В случае если
     * количество заряжаемых патронов больше, чем емкость магазина, присваивает полю bullets значение capacity.
     * @param bullets количество заряжаемых патронов
     * @throws IllegalArgumentException если количество заряжаемых патронов отрицательное.
     */
    private void setValidBullets(int bullets) {
        if (bullets < 0) throw new IllegalArgumentException("bullets must be positive");
        this.bullets = Math.min(bullets, capacity);
    }

    /**
     * Метод, заряжающий пистолет переданным в качестве параметра количеством патронов bullets. В случае, если количество
     * заряжаемых патронов превышает емкость магазина, возвращает количество лишних патронов.
     * @param bullets количество заряжаемых патронов
     * @return количество патронов, превышающих емкость магазина
     */
    public int load(int bullets) {
        setValidBullets(bullets);
        return this.bullets == capacity ? bullets - capacity : 0;
    }

    /**
     * Метод, разряжающий пистолет и возвращающий количество патронов, которые были разражены.
     * @return количество разряженных патронов.
     */
    public int unload() {
        int tmp = bullets;
        bullets = 0;
        return tmp;
    }

    /**
     * Метод, возвращающий true, если пистолет заряжен и false, если пистолет разряжен.
     * @return логическое значение состояния пистолета.
     */
    public boolean isLoaded() {
        return bullets > 0;
    }

    /**
     * Метод, осуществляющий выстрел из пистолета с отображением сведений в консоли.
     * В случае выстрела отображается "Бах!", при пустом магазине - "Клац!".
     */
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        }
        else System.out.println("Клац!");
    }
}
