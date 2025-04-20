package edu.baykov.spring.trafficlight;

/**
 * 9.2.7 Настройка светофора. Реализация интерфейса текущего состояния
 * светофора через Enum
 */


public enum EState implements State{
    OFF_STATE {
        @Override
        public String toString() {
            return "Светофор выключен";
        }
    },

    RED_STATE {
        @Override
        public String toString() {
            return "Загорелся красный свет";
        }
    },

    GREEN_STATE {
        @Override
        public String toString() {
            return "Загорелся зеленый свет";
        }
    },

    YELLOW_STATE {
        @Override
        public String toString() {
            return "Загорелся желтый свет";
        }
    },

    PURPLE_STATE {
        @Override
        public String toString() {
            return "Загорелся пурпур свет";
        }
    };

    @Override
    public void info() {
        System.out.println(this);
    }
}


