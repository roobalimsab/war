package com.thoughtworks;

public class BattalionResponse {
    private Battalion battalion;
    private Integer unsatisfiedCount;

    public Integer getUnsatisfiedCount() {
        return unsatisfiedCount;
    }

    public void setUnsatisfiedCount(Integer unsatisfiedCount) {
        this.unsatisfiedCount = unsatisfiedCount;
    }

    public Battalion getBattalion() {
        return battalion;
    }

    public void setBattalion(Battalion battalion) {
        this.battalion = battalion;
    }
}
