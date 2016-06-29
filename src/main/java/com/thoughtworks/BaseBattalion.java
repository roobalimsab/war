package com.thoughtworks;

public abstract class BaseBattalion {
    private int count;

    public BaseBattalion(Integer count) {
        this.count = count;
    }

    public abstract String getName();

    public abstract Integer getCount();

    public abstract void setCount(Integer count);

    public abstract Battalion getBattalion(Integer proposedCount);

    public abstract Integer getRank();

    public BattalionResponse getBattalionResponse(Integer opposingBattalionCount, Integer relativePower) {
        int proposedCount = 0, unsatisfiedCount = 0;
        int requiredCount = opposingBattalionCount / relativePower;
        if(requiredCount < this.count) {
            proposedCount = requiredCount;
            this.setCount(this.count -= proposedCount);
        } else {
            proposedCount = this.count;
            this.setCount(0);
            unsatisfiedCount = requiredCount - proposedCount;
        }
        BattalionResponse battalionResponse = new BattalionResponse();
        battalionResponse.setBattalion(this.getBattalion(proposedCount));
        battalionResponse.setUnsatisfiedCount(unsatisfiedCount);
        return battalionResponse;
    }

    public int compareTo(Object o) {
        if(this.getRank() < ((Battalion) o).getRank()) {
            return -1;
        }
        return 1;
    }
}
