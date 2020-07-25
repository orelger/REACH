package com.reach.model;

import java.io.Serializable;

public class Price implements Serializable,Model{

    protected double jobCost;

    public Price(String price) {
        Double toChange = null;
        setJobCost(toChange.parseDouble(price));
    }

    public void setJobCost(double jobCost) {
        this.jobCost = jobCost;
    }

    public double getJobCost() {
        return jobCost;
    }
}
