package com.epam.paper.entity;

import javax.xml.bind.annotation.*;


@XmlType(name = "Newspaper", propOrder = {"subscriptionIndex", "outputFrequency"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Newspaper extends Paper {
    @XmlElement(name = "subscription-index")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int subscriptionIndex;
    @XmlElement(name = "output-frequency")
    protected OutputFrequencyEnum outputFrequency;

    public Newspaper() {
    }

    public Newspaper(String id, String owner, String title, int price, int subscriptionIndex, OutputFrequencyEnum outputFrequency) {
        super(id, owner, title, price);
        this.subscriptionIndex = subscriptionIndex;
        this.outputFrequency = outputFrequency;
    }

    public void setSubscriptionIndex(int subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
    }

    public void setOutputFrequency(OutputFrequencyEnum outputFrequency) {
        this.outputFrequency = outputFrequency;
    }

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public OutputFrequencyEnum getOutputFrequency() {
        return outputFrequency;
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
        Newspaper newspaperObj = (Newspaper) obj;
        return this.subscriptionIndex == newspaperObj.subscriptionIndex && this.outputFrequency.equals(newspaperObj.outputFrequency);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result + subscriptionIndex + outputFrequency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", subscriptionIndex = " + subscriptionIndex + " " +
                ", outputFrequency = " + outputFrequency.toString();
    }


}
