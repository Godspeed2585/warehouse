package com.wk.warehouse.entity;
import java.time.LocalDateTime;


public class Class {
    private String license;
    private int jobId;
    private LocalDateTime times;
    private String routeId;
    private float basicPrice;
    private float firstWeight;
    private float secondweight;
    private float discountWeight;
    private String wagonId;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public float getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(float basicPrice) {
        this.basicPrice = basicPrice;
    }

    public float getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(float firstWeight) {
        this.firstWeight = firstWeight;
    }

    public float getSecondWeight() {
        return secondweight;
    }

    public void setSecondWeight(float secondweight) {
        this.secondweight = secondweight;
    }

    public float getDiscountWeight() {
        return discountWeight;
    }

    public void setDiscountWeight(float discountWeight) {
        this.discountWeight = discountWeight;
    }

    public String getWagonId() {
        return wagonId;
    }

    public void setWagonId(String wagonId) {
        this.wagonId = wagonId;
    }
}