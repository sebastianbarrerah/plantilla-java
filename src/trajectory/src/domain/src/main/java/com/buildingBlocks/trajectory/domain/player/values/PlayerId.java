package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class PlayerId extends Identity {

    public PlayerId(){
        super();
    }

    private PlayerId(String id){
        super(id);
    }

    public static PlayerId of(String id){
        return new PlayerId(id);
    }


}