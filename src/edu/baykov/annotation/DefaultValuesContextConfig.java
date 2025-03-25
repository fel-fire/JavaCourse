package edu.baykov.annotation;


/**
 8.3.2. Конфигурационный класс. Состоит из методов, порождающих объекты, являющиеся значениями по умолчанию для
 различных типов. Значения примитивов приравниваются к классам-оберткам , соответственно в случае указания нескольких
 дефолтных значений для одного типа, в контексте будет находится последнее из них.
 * @author   Nikolay Baykov
 */
class DefaultValuesContextConfig {

    Integer integer() {
        return 10;
    }

    String string() {
        return "пустая строка";
    }

    /**
     * Метод обновит значение, внесенное в контекст первым методом
     */
    int ints() {
        return 15;
    }


    Double eDouble() {
        return 5.0;
    }

    Boolean eBoolean() {
        return true;
    }

    A a() {
        return new A();
    }

    Object obj() {
        return new Object();
    }
}
