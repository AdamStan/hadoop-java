package com.adam.stan;

import java.util.Objects;

public class HandKey {
    private final String side;
    private final int personId;
    private final String fingerName;

    public HandKey(String side, int personId, String fingerName) {
        this.side = side;
        this.personId = personId;
        this.fingerName = fingerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandKey handKey = (HandKey) o;
        return personId == handKey.personId &&
                Objects.equals(side, handKey.side) &&
                Objects.equals(fingerName, handKey.fingerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(side, personId, fingerName);
    }

    @Override
    public String toString() {
        return side + "-" + personId + "-" + fingerName;
    }
}
