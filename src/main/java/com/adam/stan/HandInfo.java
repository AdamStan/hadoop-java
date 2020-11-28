package com.adam.stan;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HandInfo implements Serializable {
    // person's number
    public int series;
    // number of measurement (should be 1-20)
    public int sample;
    // Left (L) or right (R) hand
    public String side;

    public final Map<String, String> fingers= new HashMap<>();

    @Override
    public String toString() {
        return "HandInfo{" +
                "series=" + series +
                ", sample=" + sample +
                ", side='" + side + '\'' +
                ", fingers=" + fingers +
                '}';
    }
}
