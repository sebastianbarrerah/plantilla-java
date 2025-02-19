package com.buildingBlocks.trajectory.domain.player.entities;

import com.buildingBlocks.trajectory.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.shared.domain.generic.Identity;

public class Properties extends Entity<PlayerId> {
    private TypeProperty type;
    private ValueProperty value;
    private Address address;

    public Properties(TypeProperty type, ValueProperty value, Address address){
        super(new PlayerId());
        this.type = type;
        this.value = value;
        this.address = address;
    }

    public Properties(Identity id, TypeProperty type, ValueProperty value, Address address){
        super((PlayerId) id);
        this.type = type;
        this.value = value;
        this.address = address;
    }

    public TypeProperty getType() {
        return type;
    }

    public ValueProperty getValue() {
        return value;
    }

    public Address getAddress() {
        return address;
    }

    //    public changeTipo(typeProperty type){
//        typeProperty.getTypeProperty() == TypePropertyEnum.MANSION ?
//                typeProperty.setTypeProperty(TypePropertyEnum.HOUSE) :
//                typeProperty.setTypeProperty(TypePropertyEnum.MANSION);
//    }
//
//    public buyProperty(valueProperty value,){
//        const value = Properties.getValue().getValue();
//        const salaryActual = Salary.getSalary().getAmount();
//        if(value > salaryActual){
//            return system.out.println("No tienes fondos suficientes");
//        }else{
//            system.out.println("Neto:" + value);
//        }
//    }
//
//    public sellProperty(valueProperty value){
//        const amount = 1500;
//        const salaryActual = Salary.getSalary().getAmount();
//        const porcentaje = 16;
//        const total = salaryActual + (amount * porcentaje) / 100;
//        Salary.setSalary(total);
//    }


}