package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private final String name;
    private final String owner;
    private final List<Valuable> valuableList;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.valuableList = new ArrayList<>();
    }

    public void add(Valuable asset){
        valuableList.add(asset);
    }

    public double getValue(){
        double result = 0;
        for (Valuable asset : valuableList){
            result += asset.getValue();
        }
        return result;
    }

    public double getMostValuable(){
        double result = -1;
        for (Valuable asset : valuableList){
            if (asset.getValue() >= result){
                result = asset.getValue();
            }
        }
        return result;
    }
    public double getLeastValuable(){
        double result = 9999999;
        for (Valuable asset : valuableList){
            if (asset.getValue() <= result){
                result = asset.getValue();
            }
        }
        return result;
    }

}
