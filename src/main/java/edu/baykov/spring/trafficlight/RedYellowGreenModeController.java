package edu.baykov.spring.trafficlight;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;

import static edu.baykov.spring.trafficlight.EState.*;

/**
 * 9.2.7 Настройка светофора. Реализация красного-желтого-зеленого режима работы светофора
 */

@Component
@Scope("prototype")
public class RedYellowGreenModeController implements TrafficlightMode{

    Queue<State> colorSequence = new LinkedList<>();

    @PostConstruct
    private void init() {
        colorSequence.add(RED_STATE);
        colorSequence.add(YELLOW_STATE);
        colorSequence.add(GREEN_STATE);
        colorSequence.add(YELLOW_STATE);
    }

    public State changeState() {
        if (colorSequence.isEmpty()) init();
        return colorSequence.remove();
    }

    @Override
    public State setOFF_STATE() {
        colorSequence.clear();
        return OFF_STATE;
    }
}
