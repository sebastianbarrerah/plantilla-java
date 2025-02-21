package com.buildingBlocks.trajectory.domain.player;


import com.buildingBlocks.trajectory.domain.player.entities.Family;
import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingBlocks.trajectory.domain.player.values.Diner;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

    public PlayerHandler(Player player){
        add(acquireProperty(player));
        add(loseMoney(player));
        add(makeMoney(player));
        add(propertySold(player));
    }

    public Consumer<? extends DomainEvent> acquireProperty(Player player) {
        return (AcquiredProperty event) -> {
            Properties property = new Properties(event.getType(), event.getValue(), event.getAddress());
            player.getProperties().add(property);
        };
    }

    public Consumer<? extends DomainEvent> propertySold(Player player) {

        return (PropertySold event) -> player.sellProperty(event);
    }


    public Consumer<? extends DomainEvent> makeMoney(Player player) {
        return (MakeyMoney event) -> {
            player.setMoney(Diner.of(player.getMoney().getAmount()));
        };
    }

    public Consumer<? extends DomainEvent> loseMoney(Player player) {
        return (LoseMoney event) -> {
            player.setMoney(Diner.of(player.getMoney().getAmount()));
        };
    }





}
