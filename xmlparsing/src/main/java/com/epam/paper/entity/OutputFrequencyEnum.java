package com.epam.paper.entity;

public enum OutputFrequencyEnum {
    EVERY_WEEK("every week"),
    ONCE_IN_TWO_WEEKS("once in two weeks"),
    ONCE_A_MONTH("once a month");

    private String outputFrequency;

    OutputFrequencyEnum(String outputFrequency){
        this.outputFrequency = outputFrequency;
    }

}
