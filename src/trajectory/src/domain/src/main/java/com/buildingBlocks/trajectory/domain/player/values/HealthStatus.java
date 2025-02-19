package com.buildingBlocks.trajectory.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class HealthStatus implements IValueObject {
    private final StatusSaludEnum health;

    private HealthStatus(StatusSaludEnum health){
        this.health = health;
        validate();
    }

    public StatusSaludEnum getHealth() {
        return health;
    }

    public static HealthStatus of(StatusSaludEnum health){
        return new HealthStatus(health);
    }

    @Override
    public void validate() {
        ValidateUtils.validateIsNotNull(health, "el valor de la salud no puede ser null");
        ValidateUtils.validateIsNotBlank(String.valueOf(health), "el valor de la salud no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(String.valueOf(health), "el valor de la salud es requerido");
    }



}