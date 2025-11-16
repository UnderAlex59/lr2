package ru.zverev.lr2.model;

import lombok.Getter;

@Getter
public enum Position {

    DEV(2.2, false),
    HR(1.2, true),
    TL(2.6, false),
    PO(3.0, true),
    TPM(4.1, false),
    CTO(5.2, false);

    private final Double positionCoefficient;

    private final Boolean isManager;

    Position(Double positionCoefficient, Boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
