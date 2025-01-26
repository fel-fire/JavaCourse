package edu.baykov.weapon;

/**
 * <p>Класс {@code MachineRifle}, реализующий сущность "Автомат", которая описывается следующим образом:</p>
 * <p>•	Имеет Количество патронов {@code ammo} (целое не отрицательное число)</p>
 * <p>•	Имеет емкость магазина {@code capacity} (целое положительное число)</p>
 * <p>•	Имеет скорострельность в секунду {@code rateOfFire} (целое положительное число)</p>
 * <p>Класс расширяет класс {@code Handgun}, добавляя возможность осуществлять стрельбу
 * очередью в течение 1 секунды {@code shoot} и в течении n секунд {@code shoot(int seconds)}</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    16-01-2025
 */
public class MachineRifle extends Handgun {
    /**
     * Скорострельность в секунду.
     */
    final int rateOfFire;

    /**
     * Конструирует объект класса "Автомат" без патронов {@code bullets}
     * с емкостью магазина {@code capacity} 30 и скорострельностью {@code rateOfFire} 30.
     */
    public MachineRifle() {
        super(30);
        rateOfFire = 30;
    }
    /**
     * Конструирует объект класса "Автомат" без патронов с емкостью магазина {@code capacity} и скорострельностью {@code capacity}/2.
     * @param capacity емкость магазина.
     */
    public MachineRifle(int capacity) {
        super(capacity);
        rateOfFire = capacity/2;
    }

    /**
     * Конструирует объект класса "Автомат" без патронов с емкостью магазина {@code capacity} и скорострельностью {@code rateOfFire}.
     * @param capacity емкость магазина.
     * @param rateOfFire количество выстрелов в секунду.
     * @throws IllegalArgumentException в случае, если скорострельность меньше 1.
     */
    public  MachineRifle(int capacity, int rateOfFire) {
        super(capacity);
        if (rateOfFire <= 0) throw new IllegalArgumentException("RateOfFire must be more than 0");
        this.rateOfFire = rateOfFire;
    }
    /**
     * Метод, осуществляющий очередь выстрелов из автомата в течение секунды с отображением сведений в консоли.
     * В случае выстрела отображается "Бах!", при пустом магазине однократное "Клац!" и прекращение стрельбы.
     */
    @Override
    public void shoot() {
        shoot(1);
    }
    /**
     * Метод, осуществляющий очередь выстрелов из автомата в течение {@code seconds} с отображением сведений в консоли.
     * Во время выстрела отображается "Бах!", при пустом магазине или в случае, если патроны закончились во время
     * стрельбы, -  однократное "Клац!" и прекращение стрельбы.
     * @param seconds продолжительность очереди в секундах
     * @throws IllegalArgumentException если количество секунд меньше 1.
     */
    public void shoot(int seconds) {
        if (ammo == 0) {
            System.out.println("Клац!");
            return;
        }
        if (seconds < 1) throw new IllegalArgumentException("Seconds must be more than 0");
        for (int i = (rateOfFire*seconds); 0 < i; i--) {
            super.shoot();
            if (ammo == 0 && i > 1) {
                System.out.println("Клац!");
                break;
            }
        }
    }
}
