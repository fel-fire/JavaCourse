package edu.baykov.fraction;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
/**
 * Класс {@code FractionProxy} представляет реализацию прокси для обыкновенной дроби
 * с добавлением возможности кэширования вычисленных значений:
 * <p>•	Имеет кэш: {@code Map<String, Object> cache}</p>
 * <p>•	Имеет значение максимального размера кэша:  {@code int maxCacheSize}. По умолчанию значение 30</p>
 * <p>•	Реализует интерфейс {@code Fractionable}, предоставляющий пользователю возможность производить сложение с дробью
 * и получать ее целочисленное значение. В случае если результаты вычислений содержатся в кэше,
 * то повторные вычисления не выполняются.
 * @author   Nikolay Baykov
 */
public class FractionProxy implements Fractionable {

    private final Map<String, Object> cache = new HashMap<>();
    @Getter
    private int maxCacheSize = 30;

    /**
     * Здесь целенаправлено выбран класс Fraction вместо Fractionable, потому что предполагаю что
     * не правильно разделять функцию кэширования и основного действия, и давать возможность добавить
     * между ними какую-то функциональность, которая может быть не выполнена
     */
    private Fraction fraction;


    private FractionProxy(Fraction f) {
        this.fraction = f;
    }

    public static FractionProxy of(Fraction f) {
        return new FractionProxy(f);
    }

    /**
     * В этом д.з вместо {@code Fraction sum(int i)} я использовал {@code Fraction sum(Fraction f)}
     */
    @Override
    public Fraction sum(Fraction f) {
        return useWithCache(f, fraction::sum);
    }

    @Override
    public int intValue() {
        return useWithCache(Fraction::intValue);
    }

    /**
     * Метод, реализующий функциональность кэширования. Требует передачи в качестве параметра входящей дроби, а также
     * функции, которая должна быть с ней реализована посредством {@code Fraction}.
     */

    private <R> R useWithCache(Fraction f, Function<Fraction, R> function) {
        String key = generateKey(f);
        if (cache.containsKey(key)) {
            System.out.println("Получаю значение из кэша");
            return (R) cache.get(key);
        }
        System.out.println("Вычисляю значение, помещаю в кэш");
        if (cache.size() >= maxCacheSize) reduceCache();
        R result = function.apply(f);
        cache.put(key, result);
        return result;
    }

    /**
     * Тот же метод, но переопределенный для использования с методами получения значений
     * класса {@code Number}.
     */
    private <R> R useWithCache(Function<Fraction, R> function) {
        return useWithCache(fraction, function);
    }

    /**
     * Метод предназначен для определения способа формирования уникального ключа для хранения результата в кэшэ.
     * В настоящем примере уникальный ключ формируется на основе числителя и знаменателя входящей дроби, а также
     * имени метода, в котором происходит математическая операция.
     */
    private String generateKey(Fraction f) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[3].getMethodName() + " " + f.getNumerator() + "/" + f.getDenominator();
    }

    /**
     * Метод предназначен для уменьшения кэша: удаляет 1/3 значений, содержащихся в нем.
     */
    private void reduceCache() {
            int counter = 0;
            for (String s : cache.keySet()) {
                counter++;
                if (counter % 3 == 0) cache.remove(s);
            }
    }

    /**
     * Метод, предоставляющий возможность задать максимальный размер кэша. Если новое значение кэша
     * меньше, чем существующее, кэш будет обнулен.
     */
    public void setMaxCacheSize(int newCacheSize) {
        if (this.maxCacheSize > newCacheSize)
            cache.clear();
        this.maxCacheSize = newCacheSize;
    }
}
