package com.buildingBlocks.trajectory.application.changeCareer;

public class ChangeCareerResponse {
    private final String nameProfession;
    private final String educationalLevel;

    public ChangeCareerResponse(String nameProfession, String educationalLevel) {
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
    }

    public String getNameProfession() {
        return nameProfession;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }


}
