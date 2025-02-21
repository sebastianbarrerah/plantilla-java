package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateProfession extends DomainEvent {
    private String id;
    private String nameProfession;
    private String educationalLevel;
    private Integer salary;

    public UpdateProfession(String id, String nameProfession, String educationalLevel, Integer salary){
        super(EventsNameEnum.UPDATE_PROFESSION.name());
        this.id = id;
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getNameProfession() {
        return nameProfession;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public Integer getSalary() {
        return salary;
    }
}