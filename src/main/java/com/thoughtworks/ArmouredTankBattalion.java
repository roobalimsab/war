package com.thoughtworks;

public class ArmouredTankBattalion extends BaseBattalion implements Battalion {
    private int count;

    public ArmouredTankBattalion(int count) {
        super(count);
        this.count = count;
    }

    @Override
    public String getName() {
        return "Armoured Tank";
    }

    @Override
    public Integer getCount() {
        return this.count;
    }

    @Override
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public Integer getRank() {
        return 3;
    }

    @Override
    public Battalion getBattalion(Integer proposedCount) {
        return new ArmouredTankBattalion(proposedCount);
    }
}
