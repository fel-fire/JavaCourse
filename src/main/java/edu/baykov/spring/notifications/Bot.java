package edu.baykov.spring.notifications;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Component
@Scope("prototype")
@ToString
public class Bot implements StockObserver {

    Stock watchedStock;
    List<Consumer<Stock>> actions;

    @Autowired
    public void setActions(List<Consumer<Stock>> actions) {
        this.actions = actions;
    }

    public Bot(Stock stock) {
        stock.registerObserver(this);
        watchedStock = stock;
    }

    @Override
    public void update(Stock stock) {
       //if (actions == null) return;
       actions.forEach(stockConsumer -> stockConsumer.accept(watchedStock));
    }
}
