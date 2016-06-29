package com.thoughtworks;

public interface Battalion extends Comparable {
    public String getName();
    public Integer getCount();
    public void setCount(Integer count);
    public BattalionResponse getBattalionResponse(Integer opposingBattalionCount, Integer relativePower);
    public Integer getRank();
    public Battalion getBattalion(Integer proposedCount);
}
