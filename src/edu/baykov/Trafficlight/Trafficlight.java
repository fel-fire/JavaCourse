package edu.baykov.Trafficlight;

import static edu.baykov.Trafficlight.EState.*;

public class Trafficlight {
    State cur;

    private State tmp = OFF_STATE;

    State getTmp() {
        return tmp;
    }

    void setTmp(State tmp) {
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