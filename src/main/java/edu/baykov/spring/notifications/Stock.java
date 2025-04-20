package edu.baykov.spring.notifications;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Stock implements Observable {

    static private Map<String, Stock> stocks;
    static private StockRepository repository = new StockRepository();

    List<StockObserver> observers = new LinkedList<>();
    @Getter
    private String name;
    @Getter
    private int price = 0;


    private Stock(String name) {
        this.name = name;
    }

    public static Stock get(String name) {
        if (stocks == null) {
            stocks = new HashMap<>();
            repository.getStockList().forEach(x -> stocks.put(x, new Stock(x)));
        }
        if (!stocks.containsKey(name))
            throw new NoSuchElementException("Such a stock does not participate in the stock exchange");
        return stocks.get(name);
    }

    @Override
    public void registerObserver(StockObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(StockObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((o)-> o.update(this));
    }

    public void setPrice(int price) {
        if (price >= 0) this.price = price;
        else throw new IllegalArgumentException("Price can't be lesser than 0.");
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Акция: " + name + ", цена = " + price;
    }
}
