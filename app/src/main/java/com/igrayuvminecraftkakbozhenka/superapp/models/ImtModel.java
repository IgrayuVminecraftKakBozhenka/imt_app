package com.igrayuvminecraftkakbozhenka.superapp.models;

public final class ImtModel {

    private final String name;
    private final String weigh;
    private final String high;
    private final String imt;

    public ImtModel(String name, String high, String weigh, String imt) {
        this.name = name;
        this.high = high;
        this.weigh = weigh;
        this.imt = imt;
    }

    public String getName() {
        return name;
    }

    public String getWeigh() {
        return weigh;
    }

    public String getHigh() {
        return high;
    }

    public String getImt() {
        return imt;
    }

    @Override
    public String toString() {
        String s;
        return s = name + "," + high + "," + weigh + "," + imt;
    }
}
