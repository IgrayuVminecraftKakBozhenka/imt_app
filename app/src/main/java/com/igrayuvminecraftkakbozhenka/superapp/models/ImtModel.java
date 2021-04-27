package com.igrayuvminecraftkakbozhenka.superapp.models;

public final class ImtModel {

    private final String name;
    private final double weigh;
    private final double high;
    private final double imt;

    public ImtModel(String name, double high, double weigh, double imt) {
        this.name = name;
        this.high = high;
        this.weigh = weigh;
        this.imt = imt;
    }

    public String getName() {
        return name;
    }

    public double getWeigh() {
        return weigh;
    }

    public double getHigh() {
        return high;
    }

    public double getImt() {
        return imt;
    }

    @Override
    public String toString() {
        String s;
        return s = name + "," + high + "," + weigh + "," + imt;
    }
}
