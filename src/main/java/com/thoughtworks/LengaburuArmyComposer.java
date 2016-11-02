package com.thoughtworks;

import java.util.Collections;
import java.util.List;

public class LengaburuArmyComposer {

    public Army getAppropriateArmy(Army lengaburuArmy, Army falicorniaArmy, Double relativePower) {
        Army requiredArmy = new Army();
        for(Battalion opposingBattalion : falicorniaArmy.getBattalions()) {
            Battalion battalion = lengaburuArmy.getBattalion(opposingBattalion.getName());
            BattalionResponse battalionResponse = battalion.getBattalionResponse(opposingBattalion.getCount(), relativePower);
            requiredArmy.addBattalion(battalionResponse.getBattalion());

            if(battalionResponse.getUnsatisfiedCount() > 0) {
                redo(lengaburuArmy, relativePower, requiredArmy, battalion, battalionResponse);
            }
        }
        return requiredArmy;
    }

    private void redo(Army lengaburuArmy, Double relativePower, Army requiredArmy, Battalion battalion, BattalionResponse battalionResponse) {
        BattalionResponse nextBattalionResponse = getAvailableMinimumRankBattalion(battalion, lengaburuArmy.getBattalions(), battalionResponse.getUnsatisfiedCount(), relativePower);
        requiredArmy.addBattalion(nextBattalionResponse.getBattalion());
        if(nextBattalionResponse.getUnsatisfiedCount() > 0) {
            redo(lengaburuArmy, relativePower, requiredArmy, nextBattalionResponse.getBattalion(), nextBattalionResponse);
        }
    }

    private BattalionResponse getAvailableMinimumRankBattalion(Battalion prevBattalion, List<Battalion> battalions, Integer requiredCount, Double relativePower) {
        Collections.sort(battalions);
        for(Battalion battalion : battalions) {
            if(battalion.getCount() != 0) {
                BattalionResponse battalionResponse = battalion.getBattalionResponse(requiredCount, getRelativePower(prevBattalion, relativePower, battalion));
                return battalionResponse;
            }
        }
        return null;
    }

    private Double getRelativePower(Battalion prevBattalion, Double relativePower, Battalion battalion) {

        int rankDifference = battalion.getRank() - prevBattalion.getRank();
        if(rankDifference > 0) {
            return Double.parseDouble(String.valueOf(rankDifference*relativePower));
        }
        return Double.parseDouble(String.valueOf(Math.pow(relativePower, rankDifference)));
    }
}
