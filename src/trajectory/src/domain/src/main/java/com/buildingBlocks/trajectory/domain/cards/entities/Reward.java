package com.buildingBlocks.trajectory.domain.cards.entities;

import com.buildingBlocks.trajectory.domain.cards.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Reward extends Entity<CardId> {

    private final NameReward nameReward;
    private final DescriptionReward descriptionReward;
    private final TypeReward typeReward;
    private final Integer valueReward;

    public Reward(NameReward nameReward, DescriptionReward descriptionReward, TypeReward typeReward, Integer valueReward){
        super(new CardId());
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }

    public Reward(Identity id, NameReward nameReward, DescriptionReward descriptionReward, TypeReward typeReward, Integer valueReward){
        super((CardId) id);
        this.nameReward = nameReward;
        this.descriptionReward = descriptionReward;
        this.typeReward = typeReward;
        this.valueReward = valueReward;
    }

//    public  adquiereReward() {
//        typeReward.getTypeReward() == TypeEventEffectEnum.FAMILY ?
//                valueReward.setValue(valueReward.getValue() + 100) :
//                valueReward.setValue(valueReward.getValue() + 50);
//    }
//
//    public rewardUpdate() {
//        const value = valueReward.getValue();
//        int salaryActual = Salary.getSalary().getAmount();
//        if(adquiereReward()){
//            salaryActual = salaryActual + value;
//            Salary.setSalary(salaryActual);
//        }
//    }
//
//    public assignReward() {
//        long premio = 1000;
//        if(typeEvent.getTypeEvent() == typeEventEnum.individualImpact && valueReward.getValue() > 0){
//            typeReward.setTypeReward(TypeEventEffectEnum.PLAYER);
//            Salary.setSalary(Salary.getSalary().getAmount() + premio);
//        }
//    }


}