package com.epam.paper.entity;

import javax.xml.bind.annotation.*;


@XmlType(name = "magazine", propOrder = {"subject"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Magazine extends Newspaper {
    @XmlElement(name = "subject")
    private String subject;

    public Magazine() {
    }

    public Magazine(String id, String owner, String title, int price, int subscriptionIndex, OutputFrequencyEnum outputFrequency, String subject) {
        super(id, owner, title, price, subscriptionIndex, outputFrequency);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Magazine magazine = (Magazine) obj;
        return this.subject.equals(magazine.subject);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result + subject.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", subject = " + subject;
    }
}
