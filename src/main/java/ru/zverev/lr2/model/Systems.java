package ru.zverev.lr2.model;

public enum Systems {
    ERP("Enterprise Resource Planning"),

    CRM("Customer Relationship Management"),

    WMS("Warehouse Management System"),

    System_1("System 1");

    private final String name;

    Systems(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
