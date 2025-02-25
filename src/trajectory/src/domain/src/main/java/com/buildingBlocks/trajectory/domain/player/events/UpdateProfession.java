package com.buildingBlocks.trajectory.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class UpdateProfession extends DomainEvent {
    private String nameProfession;
    private String educationalLevel;

    public UpdateProfession(){
        super(EventsNameEnum.UPDATE_PROFESSION.name());
    }

    public UpdateProfession(String nameProfession, String educationalLevel){
        super(EventsNameEnum.UPDATE_PROFESSION.name());
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
    }


    public String getNameProfession() {
        return nameProfession;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }


    public void setNameProfession(String nameProfession) {
        this.nameProfession = nameProfession;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }


}