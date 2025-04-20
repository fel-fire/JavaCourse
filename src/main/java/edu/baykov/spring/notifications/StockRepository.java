package edu.baykov.spring.notifications;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

public class StockRepository {

    private List<String> stocksList;

    public StockRepository() {
        stocksList = new ArrayList<>();
        stocksList.add("ORCL");
        stocksList.add("TSLA");
        stocksList.add("SBER");
    }

    public List<String> getStockList() {
        return new ArrayList<>(stocksList);


    }
}
