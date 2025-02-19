package com.buildingBlocks.trajectory.domain.player;


import com.buildingBlocks.trajectory.domain.player.entities.Family;
import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

    public PlayerHandler(Player player){
        add(acquireProperty(player));
        add(loseMoney(player));
        add(makeMoney(player));
        add(propertySold(player));
        add(stateChange(player));
        add(updateFamily(player));
    }

    public Consumer<? extends DomainEvent> acquireProperty(Player player) {
        return (AcquiredProperty event) -> {
            Properties propiedad = new Properties(event.getType(), event.getValue(), event.getAddress());
            player.setProperty(propiedad);
        };
    }

    public Consumer<? extends DomainEvent> propertySold(Player player) {
        return (PropertySold event) -> {
            player.getProperties().remove(event.getId());
            player.setDiner(event.getValue());
        };
    };

    public Consumer<? extends DomainEvent> makeMoney(Player player) {
        return (MakeyMoney event) -> {
            player.setDiner(event.getAmount());
        };
    }

    public Consumer<? extends DomainEvent> updateFamily(Player player) {
        return (UpdateFamily event) -> {
            Family integrante = new Family(event.getCoupe(), event.getChildren());
            player.setFamily(integrante);
        };
    }

    public Consumer<? extends DomainEvent> loseMoney(Player player) {
        return (LoseMoney event) -> {
            player.setDiner(event.getAmount());
        };
    }

        public Consumer<? extends DomainEvent> stateChange (Player player){
            return (StateChange event) -> {
                player.setState(event.getState());
            };
        };
}
