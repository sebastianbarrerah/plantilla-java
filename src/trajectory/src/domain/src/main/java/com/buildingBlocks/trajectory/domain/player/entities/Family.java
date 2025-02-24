package com.buildingBlocks.trajectory.domain.player.entities;

import com.buildingBlocks.trajectory.domain.player.values.PlayerId;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Family extends Entity<PlayerId> {
    private  Boolean coupe = false;
    private  Integer children = 0;

    public Family( Boolean coupe, Integer children){
        super(new PlayerId());
        this.coupe = coupe;
        this.children = children;
    }

    public Family(Identity id, Boolean coupe, Integer children){
        super((PlayerId) id);
        this.coupe = coupe;
        this.children = children;
    }

    //region getters and setters
    public Boolean getCoupe() {
        return coupe;
    }

    public void setCoupe(Boolean coupe) {
        this.coupe = coupe;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
    //endregion
}