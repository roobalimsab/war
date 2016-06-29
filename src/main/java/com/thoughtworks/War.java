package com.thoughtworks;

import java.util.List;

public class War {

    public static void main(String[] args) {
        Army lengaburuArmy = new Army();
        lengaburuArmy.addBattalion(new HorseBattalion(100));
        lengaburuArmy.addBattalion(new ElephantBattalion(50));
        lengaburuArmy.addBattalion(new ArmouredTankBattalion(10));
        lengaburuArmy.addBattalion(new SlingGunBattalion(5));

        Army falicorniaArmy = new Army();
        falicorniaArmy.addBattalion(new HorseBattalion(204));
        falicorniaArmy.addBattalion(new ElephantBattalion(20));
        falicorniaArmy.addBattalion(new ArmouredTankBattalion(0));
        falicorniaArmy.addBattalion(new SlingGunBattalion(0));

        LengaburuArmyComposer lengaburuArmyComposer = new LengaburuArmyComposer();
        Integer relativePower = 2;
        Army proposedArmy = lengaburuArmyComposer.getAppropriateArmy(lengaburuArmy, falicorniaArmy, relativePower);
        List<Battalion> battalions = proposedArmy.getBattalions();
        for(Battalion battalion : battalions) {
            System.out.println(battalion.getName() + ":" + battalion.getCount());
        }
    }

}
