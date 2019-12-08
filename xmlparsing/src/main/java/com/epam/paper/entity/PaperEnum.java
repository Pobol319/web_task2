package com.epam.paper.entity;

public enum PaperEnum {
    PAPERS("papers"),
    PAPER("paper"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    ID("id"),
    OWNER("owner"),
    TITLE("title"),
    PRICE("price"),
    SUBSCRIPTION_INDEX("subscription-index"),
    OUTPUT_FREQUENCY("output-frequency"),
    SUBJECT("subject");

    private String value;

    PaperEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
