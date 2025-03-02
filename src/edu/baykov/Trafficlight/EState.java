package edu.baykov.Trafficlight;

public enum EState implements State{
    OFF_STATE {
        @Override
        public void make() {
            System.out.println("black");
        }
        @Override
        public void next(Trafficlight trafficlight) {
            trafficlight.cur = this;
        }
    },

    RED_STATE {
        @Override
        public void make() {
            System.out.println("red");
        }
        @Override
        public void next(Trafficlight trafficlight) {
            trafficlight.cur = GREEN_STATE;
        }
    },

    GREEN_STATE {
        @Override
        public void make() {
            System.out.println("green");
        }
        @Override
        public void next(Trafficlight trafficlight) {
            trafficlight.cur = RED_STATE;
        }

    }
}

