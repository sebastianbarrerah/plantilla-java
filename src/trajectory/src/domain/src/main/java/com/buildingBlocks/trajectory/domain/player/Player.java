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
    private List<Family> family = new ArrayList<>();
    private List<Properties> properties = new ArrayList<>();
    private Name name;
    private Diner money = new Diner(0);
    private HealthStatus stateHealth;
    private BoardPosition boardPosition;
    private State state;

    //region constructores
    public Player() {
        super(new PlayerId());
        subscribe(new PlayerHandler(this));
        apply(new LoseMoney(money));
        apply(new MakeyMoney(money));
    }

    private Player(PlayerId identity) {
        super(identity);
        subscribe(new PlayerHandler(this));
    }
    //endregion

    //region getters y setters

    public List<Properties> getProperties() {
        return properties;
    }


    public Diner getMoney() {
        return money;
    }

    public void setMoney(Diner money) {
        this.money = money;
    }

    //endregion

    public void acquireProperty(Address address, Diner value, TypeProperty type) {
        apply(new AcquiredProperty(address, value, type));
    }


    public void sellProperty(PropertySold event) {
        properties.removeIf(property -> property.getId().equals(event.getId()));
        this.money = new Diner(this.money.getAmount() + event.getValue());
    }


    public void makeMoney(Diner amount) {
        validateAmount(amount);
        this.money = new Diner(this.money.getAmount() + amount.getAmount());
        apply(new MakeyMoney(money));
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

    public static Player from(final String identity, final List<DomainEvent> events) {
        Player player = new Player(PlayerId.of(identity));
        events.forEach(player::apply);
        return player;

    }

}
