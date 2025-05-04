package edu.baykov.spring.trafficlight;



public enum EColor {
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


}


