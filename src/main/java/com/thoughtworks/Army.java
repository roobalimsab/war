package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Battalion> battalions;

    public Army() {
        this.battalions = new ArrayList<>();
    }

    public List<Battalion> getBattalions() {
        return battalions;
    }

    public Battalion getBattalion(String name) {
        for(Battalion battalion : battalions) {
            if(battalion.getName().equals(name)) {
                return battalion;
            }
        }
        return null;
    }

    public void addBattalion(Battalion battalion) {
        Battalion existingBattalion = getBattalion(battalion.getName());
        if(existingBattalion != null) {
            battalion.setCount(existingBattalion.getCount() + battalion.getCount());
        }
        battalions.remove(existingBattalion);
        battalions.add(battalion);
    }


}
