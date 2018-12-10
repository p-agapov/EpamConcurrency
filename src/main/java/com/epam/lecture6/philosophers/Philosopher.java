package com.epam.lecture6.philosophers;

class Philosopher extends Thread {
    private int sectorIndex;

    Philosopher(String name) {
        super(name);
    }

    void setSectorIndex(int sectorIndex) {
        this.sectorIndex = sectorIndex;
    }

    int getSectorIndex() {
        return sectorIndex;
    }

    void inviteTo(Table table) {
        table.sit(this);
        start();
    }
}
