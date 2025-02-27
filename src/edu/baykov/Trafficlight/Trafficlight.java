package edu.baykov.Trafficlight;

import static edu.baykov.Trafficlight.State.*;

public class Trafficlight {
    State cur;

    private State tmp = OFFSTATE;

    State getTmp() {
        return tmp;
    }

    public void setTmp(State tmp) {
        this.tmp = tmp;
    }

    public void off() {
        cur.off(this);
    }

    public void on() {
        cur.on(this);
    }

    public void next() {
        cur.make();
        cur.next(this);
    }

}