package com.thoughtworks;

import java.util.Collections;
import java.util.List;

public class LengaburuArmyComposer {

    public Army getAppropriateArmy(Army lengaburuArmy, Army falicorniaArmy, Integer relativePower) {
        Army requiredArmy = new Army();
        for(Battalion opposingBattalion : falicorniaArmy.getBattalions()) {
            Battalion battalion = lengaburuArmy.getBattalion(opposingBattalion.getName());
            BattalionResponse battalionResponse = battalion.getBattalionResponse(opposingBattalion.getCount(), relativePower);
            requiredArmy.addBattalion(battalionResponse.getBattalion());

            if(battalionResponse.getUnsatisfiedCount() > 0) {
                Battalion nextBattalion = getAvailableMinimumRankBattalion(battalion, lengaburuArmy.getBattalions(), battalionResponse.getUnsatisfiedCount());
                requiredArmy.addBattalion(nextBattalion);
            }
        }
        return requiredArmy;
    }

    private Battalion getAvailableMinimumRankBattalion(Battalion prevBattalion, List<Battalion> battalions, Integer requiredCount) {
        Collections.sort(battalions);
        for(Battalion battalion : battalions) {
            if(battalion.getCount() != 0) {
                BattalionResponse battalionResponse = battalion.getBattalionResponse(requiredCount / battalion.getRank(), 1);
                return battalionResponse.getBattalion();
            }
        }
        return null;
    }
}
