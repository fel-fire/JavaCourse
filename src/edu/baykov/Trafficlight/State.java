package edu.baykov.Trafficlight;

import static edu.baykov.Trafficlight.EState.OFF_STATE;
import static edu.baykov.Trafficlight.EState.RED_STATE;

public interface State {
    void make();
    void next(Trafficlight trafficlight);

    default void off(Trafficlight trafficlight) {
        trafficlight.setTmp(trafficlight.cur);
        trafficlight.cur = OFF_STATE;
    }
    default void on(Trafficlight trafficlight) {
        trafficlight.cur = trafficlight.getTmp() == OFF_STATE ? RED_STATE : trafficlight.getTmp();
    }

}
