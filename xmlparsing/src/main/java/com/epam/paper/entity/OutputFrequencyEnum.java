package com.epam.paper.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "OutputFrequencyEnum")
@XmlEnum
public enum OutputFrequencyEnum {
    @XmlEnumValue("every_week")
    EVERY_WEEK("every week") {
        public String toString() {
            return "every week";
        }
    },
    @XmlEnumValue("once_in_two_weeks")
    ONCE_IN_TWO_WEEKS("once in two weeks") {
        public String toString() {
            return "once in two weeks";
        }
    },
    @XmlEnumValue("once_a_month")
    ONCE_A_MONTH("once a month") {
        public String toString() {
            return "once a month";
        }
    };

    private String outputFrequency;

    OutputFrequencyEnum(String outputFrequency) {
        this.outputFrequency = outputFrequency;
    }


}
