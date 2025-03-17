package com.jaafarfora.hospital_simulator.enums;

public enum Drug {
    ASPIRIN("As"),
    ANTIBIOTIC("An"),
    INSULIN("I"),
    PARACETAMOL("P");

    private final String id;

    Drug(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
