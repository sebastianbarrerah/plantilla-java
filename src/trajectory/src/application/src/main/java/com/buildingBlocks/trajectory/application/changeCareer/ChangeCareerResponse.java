package com.buildingBlocks.trajectory.application.changeCareer;

public class ChangeCareerResponse {
    private final String nameProfession;
    private final String educationalLevel;
    private final Integer salary;

    public ChangeCareerResponse(String nameProfession, String educationalLevel, Integer salary) {
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
        this.salary = salary;
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
