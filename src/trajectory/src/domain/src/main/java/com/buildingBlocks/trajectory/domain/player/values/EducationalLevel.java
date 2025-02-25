package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class EducationalLevel implements IValueObject {
    private final String level;

    private EducationalLevel(String level){
        this.level = level;
        validate();
    }

    public static EducationalLevel of(String level){
        return new EducationalLevel(level);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotEmpty(String.valueOf(level), "el nivel de educacion no puede ser null");
    }

    public String getLevel() {
        return level;
    }
}