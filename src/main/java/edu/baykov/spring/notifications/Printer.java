package edu.baykov.spring.notifications;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Printer implements StockObserver {
    List<Stock> displayedStocks = new ArrayList<>();

    public void addDisplayedStocks(Stock... stocks) {
        Arrays.stream(stocks).forEach(stock -> {
            displayedStocks.add(stock);
            stock.registerObserver(this);
        });
        print();
    }

    @Override
    public void update(Stock stock) {
        print();
    }

    private void print() {
        displayedStocks.forEach(x -> System.out.print(x + "; "));
        System.out.println();
    }


}
