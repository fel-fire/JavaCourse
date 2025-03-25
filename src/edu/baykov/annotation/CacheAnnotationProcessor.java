package edu.baykov.annotation;

import lombok.SneakyThrows;

import java.lang.reflect.*;
import java.util.*;

/**
 8.3.6. Обработчик аннотации {@code @Cache}, со следующими характеристиками:
 принимаtn произвольный набор объектов по ссылкам типа T.
 Кэширование выполняется только для тех объектов, которые проаннотированы с помощью @Cache.
 •	Если для аннотации задан набор строк, то они учитываются как названия
 методов подлежащих кэшированию. Остальные методы – не кэшируются
 * @author   Nikolay Baykov
 */

public class CacheAnnotationProcessor {
    /**
     * В этом методе все объекты проверяются на наличие @Cache, для указанных объектов создается прокси, которые
     * метод возвращает в виде списка.
     */
    @SneakyThrows
    public static <T> List<T> cache(T... objects) {
        List<T> cachedList = new ArrayList<>();
        for (T object : objects) {
            Class<T> objClass = (Class<T>) object.getClass();
            if (objClass.isAnnotationPresent(Cache.class)) {
                T proxy = (T) Proxy.newProxyInstance(
                        objClass.getClassLoader(),
                        objClass.getInterfaces(),
                        new CacheHandler(object)
                );
                cachedList.add(proxy);
            }
        }
        return cachedList;
    }
}

/**
 * Обработчик для прокси, выполняющий функцию кеширования
 */

class CacheHandler implements InvocationHandler {
    Object object;
    /**
     * Кэш результатов выполнения методов
     */
    Map<Method, Object> cache = new HashMap<>();
    /**
     * Состояние объекта на момент создания прокси
     */
    Map<Field, Object> objectCondition = new HashMap<>();


    public CacheHandler(Object object) {
        this.object = object;
        getFields(object);

    }

    /**
     * invoke метод, проверяет наличие у объекта аннотации и ее параметры,
     * вызывает метод объекта с кэшированием, либо без него.
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Class<?> objClass = object.getClass();
        Cache annotation = objClass.getAnnotation(Cache.class);
        String[] methodNames = annotation.value();

        if (methodNames.length == 0)
            return simpleCache(method);
        else {
            for (String name : methodNames) {
                if (method.getName().equals(name)) return simpleCache(method);
            }
        }
        return method.invoke(object);
    }

    /**
     * Метод реализующий использование кэша и его заполнение
     */
    private Object simpleCache(Method method) throws IllegalAccessException, InvocationTargetException {
        if (cache.containsKey(method) && !isModified()) {
            System.out.println("get value from cache");
            return cache.get(method);
        }
        else {
            Object result = method.invoke(object);
            if (method.getReturnType() != void.class) cache.put(method, result);
            return result;
        }
    }

    /**
     * Метод, собирающий значения всех полей класса, полей всех объектов, являющихся полями класса, в том числе для унаследованных полей.
     * Указанные значения помещаются в objectCondition с ключем в виде своего поля Field.
     */
    @SneakyThrows
    private void getFields(Object object) {
        Class clazz = object.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Class type = f.getType();
                if (type.isPrimitive() || type == String.class || isWrapper(type)) {
                    objectCondition.put(f, f.get(object));
                } else {
                    Object subObject = f.get(object);
                    objectCondition.put(f, subObject);
                    if (Objects.isNull(subObject)) continue;
                    getFields(subObject);
                }
            }

            clazz = clazz.getSuperclass();
        }
    }
    /**
     * Метод, проверяющий изменилось ли состояние объекта следующим образом: у каждой пары получает реальное
     * значение поля из ключа Field и сравнивает его с тем, которое хранится в objectCondition. Если значения
     * различаются - возвращает true и записывает новое значение в objectCondition
     */
    @SneakyThrows
    private boolean isModified() {
        for (Map.Entry<Field, Object> entry : objectCondition.entrySet()) {
            Field key = entry.getKey();
            Object value = key.get(object);
            Object expected = entry.getValue();
            if (Objects.nonNull(value) && !value.equals(expected) ||
                    Objects.isNull(value) && null != expected) {
                objectCondition.put(key, value);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод указывающий, является ли представленный тип оберткой над примитивом
     */

    private boolean isWrapper(Class<?> type) {
        return type == Integer.class ||
                type == Double.class ||
                type == Byte.class ||
                type == Long.class ||
                type == Short.class ||
                type == Float.class ||
                type == Boolean.class ||
                type == Character.class;
    }
}


