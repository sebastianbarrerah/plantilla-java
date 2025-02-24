package com.buildingBlocks.trajectory.domain.cards.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidateUtils;

public class Card implements IValueObject {
    private final String nameCard;
    private final String efectCard;
    private final Integer valueCard;

    private Card(String nameCard, String efectCard, Integer valueCard) {
        this.nameCard = nameCard;
        this.efectCard = efectCard;
        this.valueCard = valueCard;
        validate();
    }

    public static Card of(String nameCard, String efectCard, Integer valueCard) {
        return new Card(nameCard, efectCard, valueCard);
    }

    public String getNameCard() {
        return nameCard;
    }

    public String getEfectCard() {
        return efectCard;
    }

    public Integer getValueCard() {
        return valueCard;
    }

    public void validate() {
        ValidateUtils.validateIsNotBlank(nameCard, "el nombre de la carta no puede estar vacio");
        ValidateUtils.validateIsNotEmpty(nameCard, "el nombre de la carta es requerido");
        ValidateUtils.validateIsString(nameCard, "el nombre de la carta no puede ser un numero");
        ValidateUtils.validateIsNotNull(nameCard, "el nombre de la carta no puede ser null");

        ValidateUtils.validateIsNotBlank(efectCard, "el efecto de la carta no puede estar vacio");
    }
}
