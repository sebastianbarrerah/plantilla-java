package com.buildingBlocks.trajectory.domain.player;

import com.buildingBlocks.trajectory.domain.player.entities.Family;
import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.entities.UniversityCareer;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingBlocks.trajectory.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class Player extends AggregateRoot<PlayerId> {
    private UniversityCareer career;
    private Family family;
    private List<Properties> propiedades = new ArrayList<>();
    private Name name;
    private Diner money;
    private BoardPosition boardPosition;

    //region constructores
    public Player() {
        super(new PlayerId());
        subscribe(new PlayerHandler(this));
    }

    private Player(PlayerId identity) {
        super(identity);
        subscribe(new PlayerHandler(this));
    }

    //endregion

    //region getters and setters
    public UniversityCareer getCareer() {
        return career;
    }

    public void setCareer(UniversityCareer career) {
        this.career = career;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Properties> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Properties> updatedProperties) {
    }

    public Diner getMoney() {
        return money;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


    public void setMoney(Diner money) {
    }

    public BoardPosition getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(BoardPosition boardPosition) {
        this.boardPosition = boardPosition;
    }


    public void setState(State state) {
    }

    //endregion

    //region acciones
    public void playerMoved(Integer position) {
        apply(new MovePosition(position));
    }

    public void playerMarried(Boolean isMarried) {
        apply(new PlayerMarried(isMarried));
    }

    public void updateFamily(Integer children) {
        apply(new UpdateFamily(children));
    }

    public void acquireProperty(String address, Integer value, String type) {
        apply(new AcquiredProperty(address, value, type));
    }

    public void updateProfession(String nameProfession, String educationalLevel, Integer salary) {
        apply(new UpdateProfession(nameProfession, educationalLevel, salary));
    }

    public void playerCreated(String name) {
        apply(new PlayerCreated(name));
    }

    public void propertySold(String address, Integer values, String type) {
        apply(new PropertySold(address, values, type));
    }
    //endregion

    //region metodo de recontruccion

    public static Player from(final String identity, final List<DomainEvent> events) {
        Player player = new Player(PlayerId.of(identity));
        events.forEach(player::apply);
        return player;
    }



    //endregion

}
