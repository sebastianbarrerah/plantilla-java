package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class EducationalLevel implements IValueObject {
    private final StatusLevelEnum level;

    private EducationalLevel(StatusLevelEnum level){
        this.level = level;
        validate();
    }

    public static EducationalLevel of(StatusLevelEnum level){
        return new EducationalLevel(level);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotBlank(String.valueOf(level), "el nivel de educacion no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(level), "el nivel de educacion no puede ser null");
    }

    public StatusLevelEnum getLevel() {
        return level;
    }
}