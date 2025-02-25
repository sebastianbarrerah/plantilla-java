package com.buildingBlocks.trajectory.application.changeCareer;

import com.buildingblock.shared.application.Request;

public class ChangeCareerRequest extends Request {
    private final String nameProfession;
    private final String educationalLevel;
//    private final String cardType;
//    private final String cardEffect;

    public ChangeCareerRequest(String nameProfession, String educationalLevel) {
        super(null);
        this.nameProfession = nameProfession;
        this.educationalLevel = educationalLevel;
//        this.cardType = cardType;
//        this.cardEffect = cardEffect;
    }

    public String getNameProfession() {
        return nameProfession;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }



//    public String getCardType() {
//        return cardType;
//    }
//
//    public String getCardEffect() {
//        return cardEffect;
//    }
}
