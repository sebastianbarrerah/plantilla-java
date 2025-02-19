package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingBlocks.trajectory.domain.player.values.EducationalLevel;
import com.buildingBlocks.trajectory.domain.player.values.Name;
import com.buildingBlocks.trajectory.domain.player.values.NameProfession;
import com.buildingBlocks.trajectory.domain.player.values.Salary;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateProfession extends DomainEvent {
    private final String id;
    private final NameProfession nameProfession;
    private final EducationalLevel educationalLevel;
    private final Salary salary;

    public UpdateProfession(String id, Name name, NameProfession nameProfession, EducationalLevel educationalLevel, Salary salary){
        super(EventsNameEnum.UPDATE_PROFESSION.name());
        this.id = id;
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public NameProfession getNameProfession() {
        return nameProfession;
    }

    public EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }

    public Salary getSalary() {
        return salary;
    }
}