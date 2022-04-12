package com.example.gonzaga_wagecalculator.Controller;

public class Functions {

    public double solveOT(double hours){
        double overtime;
        if (hours > 8) {
            overtime = hours - 8;
        } else {
            overtime = 0;
        }
        return overtime;
    }

    public double solveRegWage(String employeeType, double hours, double overtime){
        double regWage;
        if (employeeType.equals("Regular")){
            regWage = (hours - overtime) * 100;
        } else if (employeeType.equals("Probationary")){
            regWage = (hours - overtime) * 90;
        } else {
            regWage = (hours - overtime) * 75;
        }
        return regWage;
    }

    public double solveOTWage(String employeeType, double overtime){
        double otWage;
        if (employeeType.equals("Regular")){
            otWage = overtime * 115;
        } else if (employeeType.equals("Probationary")){
            otWage = overtime * 100;
        } else {
            otWage = overtime * 90;
        }
        return otWage;
    }

    public double solveTotalWage(double regWage, double otWage){
        return regWage + otWage;
    }
}
