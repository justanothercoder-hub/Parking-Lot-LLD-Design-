package com.Parkinglot.Models;

public class Slot {
    private int slotNumber;
    private Car parkedCar;

    public Slot(int slotNumber){
        this.slotNumber=slotNumber;
        this.parkedCar=null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void setParkedcar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }

    public boolean isFree(){
            if(parkedCar==null){return true;}
             else{return false;}
    }
}
