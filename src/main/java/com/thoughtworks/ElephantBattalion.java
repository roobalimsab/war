package com.thoughtworks;

public class ElephantBattalion extends BaseBattalion implements Battalion {
    private int count;

    public ElephantBattalion(int count) {
        super(count);
        this.count = count;
    }

    @Override
    public String getName() {
        return "Elephant";
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
        return 2;
    }

    @Override
    public Battalion getBattalion(Integer proposedCount) {
        return new ElephantBattalion(proposedCount);
    }
}
