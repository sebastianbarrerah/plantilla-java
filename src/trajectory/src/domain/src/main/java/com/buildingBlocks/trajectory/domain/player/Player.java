package com.buildingBlocks.trajectory.domain.player;

import com.buildingBlocks.trajectory.domain.player.entities.Family;
import com.buildingBlocks.trajectory.domain.player.entities.Properties;
import com.buildingBlocks.trajectory.domain.player.entities.UniversityCareer;
import com.buildingBlocks.trajectory.domain.player.events.*;
import com.buildingBlocks.trajectory.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainActionsHandler;

import java.util.ArrayList;
import java.util.List;

public class Player extends AggregateRoot<PlayerId> {
    private UniversityCareer career;
    private List<Family> family = new ArrayList<>();
    private List<Properties> properties = new ArrayList<>();
    private Name name;
    private Diner money;
    private HealthStatus stateHealth;
    private BoardPosition boardPosition;
    private State state;

    public UniversityCareer getCareer() {
        return career;
    }

    public void setCareer(UniversityCareer career) {
        this.career = career;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Diner getMoney() {
        return money;
    }

    public void setMoney(Diner money) {
        this.money = money;
    }

    public HealthStatus getStateHealth() {
        return stateHealth;
    }

    public void setStateHealth(HealthStatus stateHealth) {
        this.stateHealth = stateHealth;
    }

    public BoardPosition getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(BoardPosition boardPosition) {
        this.boardPosition = boardPosition;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Player() {
        super(new PlayerId());
        this.money = new Diner(0);
        DomainActionsHandler.subscribe(new PlayerHandler(this));
        apply(new LoseMoney(new Diner(0)));
        apply(new MakeyMoney(new Diner(0)));
    }

    private Player(PlayerId identity) {
        super(identity);
        this.money = new Diner(0);
        DomainActionsHandler.subscribe(new PlayerHandler(this));
    }

    public void acquireProperty(Address address, ValueProperty value, TypeProperty type) {
        apply(new AcquiredProperty(address, value, type));
    }

    public void propertySold(String id, Address address, Diner value, TypeProperty type) {
        apply(new PropertySold(id, address, value, type));
    }

    public void stateChange(StatePlayerEnum state) {
        apply(new StateChange(state));
    }

    public void updateFamily(Children children, Coupe coupe) {
        apply(new UpdateFamily(children, coupe));
    }

    public void makeMoney(Diner amount) {
        validateAmount(amount);
        this.money = new Diner(this.money.getAmount() + amount.getAmount());
        apply(new MakeyMoney(amount));
    }

    private void validateAmount(Diner amount) {
    }

    public void loseMoney(Diner amount) {
        if (this.money.getAmount() < amount.getAmount()) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        this.money = new Diner(this.money.getAmount() - amount.getAmount());
        apply(new LoseMoney(amount));
    }

    public void setFamily(Family integrante) {
    }

    public void setDiner(Diner value) {
    }

    public void setProperty(Properties propiedad) {
    }
}
