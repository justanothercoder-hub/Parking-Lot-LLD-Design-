package com.Parkinglot.Repositories;

import com.Parkinglot.Models.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotRepository {
    private int n;
    private HashMap<Integer,Slot> slots;

    public ParkingLotRepository(int n){
        this.n=n;
        this.slots=new HashMap<Integer,Slot>();

        for(int i=1; i<=n; i++){
            Slot slot=new Slot(i);
            slots.put(i,slot);
        }   
    }

    public Slot getSlot(int slotNumber){
        return slots.get(slotNumber);
    }

    public List<Slot> getAllSlots(){
        return new ArrayList<>(slots.values());
    }

    public int getCapacity(){
        return slots.size();
    }
}
