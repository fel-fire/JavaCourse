package edu.baykov.spring.notifications;

public interface Observable {
    void registerObserver(StockObserver object);
    void removeObserver(StockObserver object);
    void notifyObservers();
}
