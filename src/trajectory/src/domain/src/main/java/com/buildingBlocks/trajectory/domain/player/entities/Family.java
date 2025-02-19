package com.buildingBlocks.trajectory.domain.player.entities;

import com.buildingBlocks.trajectory.domain.player.values.Children;
import com.buildingBlocks.trajectory.domain.player.values.Coupe;
import com.buildingBlocks.trajectory.domain.player.values.PlayerId;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Family extends Entity<PlayerId> {
    private  Coupe couple;
    private  Children children;

    public Family( Coupe couple, Children children){
        super(new PlayerId());
        this.couple = couple;
        this.children = children;
    }

    public Family(Identity id, Coupe couple, Children children){
        super((PlayerId) id);
        this.couple = couple;
        this.children = children;
    }

    public Coupe getCouple() {
        return couple;
    }

//    public Children addChildrenToFamily() {
//        children.getNumberOfChildren() == 0 ?
//                children.setNumberOfChildren(1) :
//                children.setNumberOfChildren(children.getNumberOfChildren() + 1);
//        return null;
//    };
//
//    public StateChange changeStateOfPlayer() {
//        StateChange.getStateChange().getStatePlayer() == StatePlayerEnum.ACTIVE ?
//                StateChange.getStateChange().setStatePlayer(StatePlayerEnum.RETIRED) :
//                StateChange.getStateChange().setStatePlayer(StatePlayerEnum.ACTIVE);
//        return null;
//    };

}