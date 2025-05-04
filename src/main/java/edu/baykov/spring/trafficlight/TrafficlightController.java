package edu.baykov.spring.trafficlight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 9.2.7 Настройка светофора. Реализация конкретного режима работы светофора
 */

@Component
@Scope("prototype")
public class TrafficlightController implements TrafficlightMode{

    private List<State> colorSequence;
    private State offState;
    private int counter;

    public TrafficlightController(@Qualifier("RYG") List<State> colorSequence,
                                  @Qualifier("off") State offState) {
        this.colorSequence = colorSequence;
        this.offState = offState;
        System.out.println(colorSequence.size());
    }

    public State changeState() {
        if (counter == colorSequence.size()) counter = 0;
        return colorSequence.get(counter++);
    }

    @Override
    public State setOffState() {
        counter = 0;
        return offState;
    }
}
