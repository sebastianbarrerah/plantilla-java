package com.buildingBlocks.trajectory.domain.player;


import com.buildingBlocks.trajectory.domain.player.entities.Family;
import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.entities.UniversityCareer;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingBlocks.trajectory.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.List;
import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

    //region constructores
    public PlayerHandler(Player player){
        add(acquireProperty(player));
        add(movePosition(player));
        add(playerCreated(player));
        add(playerMarried(player));
        add(updateFamily(player));
        add(updateProfession(player));
        add(propertySold(player));
    }
    //endregion

    //region acciones

    public Consumer<? extends DomainEvent> movePosition(Player player) {
        return (MovePosition event) -> {
            if (event.getPosition() >= 0 && event.getPosition() <= 300) {
                player.setBoardPosition(BoardPosition.of(event.getPosition()));
            }
        };
    }

    public Consumer<? extends DomainEvent> acquireProperty(Player player) {
        return (AcquiredProperty event) -> {
            Properties property = new Properties(TypeProperty.of(event.getType()), Diner.of(event.getValue()), Address.of(event.getAddress()));
            player.getPropiedades().add(property);
        };
    }

    public Consumer<? extends DomainEvent> playerCreated(Player player) {
        return (PlayerCreated event) -> {
            player.setName(Name.of(event.getName()));
            player.setState(State.of(StatePlayerEnum.ACTIVE));
            player.setMoney(Diner.of(event.getInitalMoney()));
            player.setBoardPosition(BoardPosition.of(event.getInitalPosition()));
        };
    }

    public Consumer<? extends DomainEvent> playerMarried(Player player) {
        return (PlayerMarried event) -> {
            Family family = new Family(event.getIsMarried(), Children.of(0).getNumberOfChildren());



        };
    }

    public Consumer<? extends DomainEvent> updateFamily(Player player) {
        return (UpdateFamily event) -> {
            if (event.getChildren() >= 0 && event.getChildren() <= 4) {
                if (player.getFamily() == null) {
                    player.setFamily(new Family(false, event.getChildren()));
                } else {
                    player.getFamily().setChildren(event.getChildren());
                }
            } else {
                throw new IllegalArgumentException("No se puede tener más de 4 hijos");
            }
        };
    }

    public Consumer<? extends DomainEvent> updateProfession(Player player) {
        return (UpdateProfession event) -> {
            UniversityCareer career = new UniversityCareer(Name.of(event.getNameProfession()), EducationalLevel.of(event.getEducationalLevel()), Salary.of(event.getSalary()));
            player.setCareer(career);
        };
    }

    public Consumer<? extends DomainEvent> propertySold(Player player) {
        return (PropertySold event) -> {
            List<Properties> updatedProperties = player.getPropiedades().stream()
                    .filter(casa -> !casa.getAddress().equals(event.getAddress()))
                    .toList();
            player.setPropiedades(updatedProperties);
        };
    }

    //endregion

}


























