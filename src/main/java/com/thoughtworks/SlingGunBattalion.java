package com.thoughtworks;

public class SlingGunBattalion extends BaseBattalion implements Battalion {
    private int count;

    public SlingGunBattalion(int count) {
        super(count);
        this.count = count;
    }

    @Override
    public String getName() {
        return "Sling Gun";
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
        return 4;
    }

    @Override
    public Battalion getBattalion(Integer proposedCount) {
        return new SlingGunBattalion(proposedCount);
    }
}
