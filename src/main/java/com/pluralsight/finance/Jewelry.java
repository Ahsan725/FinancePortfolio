package com.pluralsight.finance;

public class Jewelry extends FixedAsset {
    private final double karat;


    public Jewelry(String name, double marketValue, double karat) {
        super(name, marketValue);
        this.karat = karat;
        setMarketValue(marketValue * karat);
    }

    public double getKarat() {
        return karat;
    }

    @Override
    public double getValue() {
        return getMarketValue() * karat;
    }

}
