package com.buildingBlocks.trajectory.domain.player.entities;

import com.buildingBlocks.trajectory.domain.player.values.EducationalLevel;
import com.buildingBlocks.trajectory.domain.player.values.Name;
import com.buildingBlocks.trajectory.domain.player.values.PlayerId;
import com.buildingBlocks.trajectory.domain.player.values.Salary;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class UniversityCareer extends Entity<PlayerId> {
    private Name name;
    private EducationalLevel educationalLevel;
    private Salary salary;

    public UniversityCareer(Name name, EducationalLevel educationalLevel, Salary salary){
        super(new PlayerId());
        this.name = name;
        this.educationalLevel = educationalLevel;
        this.salary = salary;
    }

    public UniversityCareer(Identity id, Name name, EducationalLevel educationalLevel, Salary salary){
        super((PlayerId) id);
        this.name = name;
        this.educationalLevel = educationalLevel;
        this.salary = salary;
    }

    //region getters and setters
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(EducationalLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    //endregion
}