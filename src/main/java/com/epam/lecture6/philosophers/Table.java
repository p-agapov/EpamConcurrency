package com.epam.lecture6.philosophers;

import lombok.Synchronized;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;

class Table {

    private final List<Sector> sectors = new LinkedList<>();

    @Synchronized
    void sit(Philosopher philosopher) {
        int lastSectorIndex = sectors.size();
        sectors.add(new Sector(lastSectorIndex, new Stick()));

        int philosopherIndex = lastSectorIndex + 1;
        sectors.add(new Sector(philosopherIndex, philosopher));
        philosopher.setSectorIndex(philosopherIndex);
    }

    Stick getLeftStick(Philosopher philosopher) {
        return (Stick) sectors.get(philosopher.getSectorIndex() - 1).getObject();
    }

    Stick getRightStick(Philosopher philosopher) {
        return (Stick) sectors.get((philosopher.getSectorIndex() + 1) % sectors.size()).getObject();
    }

    Stick getStickWithLowestIndex(Philosopher philosopher) {
        int indexStick = Math.min(philosopher.getSectorIndex() - 1, (philosopher.getSectorIndex() + 1) % sectors.size());
        return (Stick) sectors.get(indexStick).getObject();
    }

    Stick getStickWithHighestIndex(Philosopher philosopher) {
        int indexStick = Math.max(philosopher.getSectorIndex() - 1, (philosopher.getSectorIndex() + 1) % sectors.size());
        return (Stick) sectors.get(indexStick).getObject();
    }

    @Value
    private static class Sector {
        int index;
        Object object;
    }
}
