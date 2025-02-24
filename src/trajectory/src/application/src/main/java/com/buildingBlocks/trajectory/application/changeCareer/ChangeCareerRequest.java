package com.buildingBlocks.trajectory.application.changeCareer;

import com.buildingblock.shared.application.Request;

public class ChangeCareerRequest extends Request {
    private final String nameProfession;
    private final String educationalLevel;
    private final Integer salary;
    private final String cardType;
    private final String cardEffect;

    public ChangeCareerRequest(String aggregateId, String nameProfession, String educationalLevel, Integer salary, String cardType, String cardEffect) {
        super(aggregateId);
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
        this.salary = salary;
        this.cardType = cardType;
        this.cardEffect = cardEffect;
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

    public String getCardType() {
        return cardType;
    }

    public String getCardEffect() {
        return cardEffect;
    }
}
