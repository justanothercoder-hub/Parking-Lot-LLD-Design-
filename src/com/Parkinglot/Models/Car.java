package com.Parkinglot.Models;

public class Car {

    private String color;
    private String RegNo;

    public Car(String color,String RegNo){
        this.color=color;
        this.RegNo=RegNo;
    }

    public String getRegistrationNumber(){
        return RegNo;
    }

    public void setRegistrationNumber(String RegNo){
        this.RegNo=RegNo;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
    }
}
