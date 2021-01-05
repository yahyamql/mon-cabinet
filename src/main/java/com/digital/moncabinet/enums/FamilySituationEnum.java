package com.digital.moncabinet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FamilySituationEnum {
    SINGLE("Célibataire"),
    DIVORCED("Divorcé(e)"),
    MARIED("Marié(e)");

    private String label;
}
