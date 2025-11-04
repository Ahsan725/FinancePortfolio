package com.pluralsight.finance;

public class House extends FixedAsset {
    private final int yearBuiltIn;
    private final int squareFeet;
    private final int bedrooms;

    public House(String name, double marketValue, int yearBuiltIn, int squareFeet, int bedrooms) {
        super(name, marketValue);
        this.yearBuiltIn = yearBuiltIn;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    public int getYearBuiltIn() {
        return yearBuiltIn;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    @Override
    public double getValue() {
        return getMarketValue();
    }
}
