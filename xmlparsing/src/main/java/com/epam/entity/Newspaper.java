package com.epam.entity;

public class Newspaper extends Paper {
    private int subscriptionIndex;
    private OutputFrequencyEnum outputFrequency;

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
                ", outputFrequency = " + outputFrequency.toString() ;
    }


}
