package com.willian.trabalho.enums;

public enum optionEnum {
    YES("SIM"),
    NO("NÃO");

    private String option;

    optionEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
