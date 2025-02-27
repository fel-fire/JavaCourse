package edu.baykov.Trafficlight;

public enum State {
    OFFSTATE {
        @Override
        public void make() {
            System.out.println("black");
        }
        @Override
        public void next(Trafficlight trafficlight) {
            trafficlight.cur = this;
        }
    },

    REDSTATE {
        @Override
        public void make() {
            System.out.println("red");
        }
        @Override
        public void next(Trafficlight trafficlight) {
            trafficlight.cur = GREENSTATE;
        }
    },

    GREENSTATE {
        @Override
        public void make() {
            System.out.println("green");
        }
        @Override
        public void next(Trafficlight trafficlight) {
            trafficlight.cur = REDSTATE;
        }

    };

    public abstract void make();
    public abstract void next(Trafficlight trafficlight);


    public void off(Trafficlight trafficlight) {
        trafficlight.setTmp(trafficlight.cur);
        trafficlight.cur = OFFSTATE;
    }
    public void on(Trafficlight trafficlight) {
        trafficlight.cur = trafficlight.getTmp() == OFFSTATE ? REDSTATE : trafficlight.getTmp();
    }
}

