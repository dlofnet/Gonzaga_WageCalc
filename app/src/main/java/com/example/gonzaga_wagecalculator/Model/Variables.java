package com.example.gonzaga_wagecalculator.Model;

public class Variables {

    private double hours, overtime, regWage, otWage, totalWage;
    private String name,
            employeeType = "";

    public Variables() { }

    //Getters
    public double getHours() { return hours; }
    public double getOvertime() { return overtime; }
    public double getRegWage() { return regWage; }
    public double getOtWage() { return otWage; }
    public double getTotalWage() { return totalWage; }
    public String getName() { return name; }
    public String getEmployeeType() { return employeeType; }

    //Setters
    public void setHours(double hours) { this.hours = hours; }
    public void setOvertime(double overtime) { this.overtime = overtime; }
    public void setRegWage(double regWage) { this.regWage = regWage; }
    public void setOtWage(double otWage) { this.otWage = otWage; }
    public void setTotalWage(double totalWage) { this.totalWage = totalWage; }
    public void setName(String name) { this.name = name; }
    public void setEmployeeType(String employeeType) { this.employeeType = employeeType; }
}
