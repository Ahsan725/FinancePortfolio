package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private final double weight; //in grams


    public Gold(String name, double marketValue, double weight) {
        super(name, marketValue);
        this.weight = weight;
        setMarketValue(marketValue * weight);
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getValue() {
        return getMarketValue() * weight;
    }

}
