package com.thoughtworks;

public class HorseBattalion extends BaseBattalion implements Battalion {
    private int count;

    public HorseBattalion(int count) {
        super(count);
        this.count = count;
    }

    @Override
    public String getName() {
        return "Horse";
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
        return 1;
    }

    @Override
    public Battalion getBattalion(Integer proposedCount) {
        return new HorseBattalion(proposedCount);
    }
}
